import de.vandermeer.asciitable.AsciiTable;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class QueryUtils {

    private static final String pathToSqlQuery = "src/main/resources/queries/";
    private static final String pathToProperties = "src/main/resources/credentials.properties";

    private static String getQueryString(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(pathToSqlQuery + fileName));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        String property = System.getProperty("line.separator");
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(property);
        }
        return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
    }

    private static ResultSet prepareToQuery(String sqlQuery) throws SQLException {
        return DriverManager.getConnection(String.format(("jdbc:mysql://%s:%s/%s"), getParameter("ip"), getParameter("port"), getParameter("dataBase")), getParameter("user"), getParameter("password")).prepareStatement(sqlQuery).executeQuery();
    }

    private static String getParameter(String parameter) {
        Properties property = new Properties();
        try {
            property.load(new FileInputStream(pathToProperties));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property.getProperty(parameter);
    }

    public static void outResultQuery(String sqlFileName) throws IOException, SQLException {
        ResultSet resultSet = QueryUtils.prepareToQuery(QueryUtils.getQueryString(sqlFileName));
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        ArrayList<String> columns = new ArrayList<>();
        for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
            columns.add(resultSetMetaData.getColumnLabel(i));
        }
        AsciiTable header = new AsciiTable();
        header.addRow(columns);
        header.addRule();
        System.out.println(header.render());
        while (resultSet.next()) {
            AsciiTable results = new AsciiTable();
            List<String> row = new ArrayList<>();
            for (String column : columns) {
                row.add(resultSet.getString(column));
            }
            results.addRow(row);
            results.addRule();
            System.out.println(results.render());
        }
    }
}
