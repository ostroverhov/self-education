import de.vandermeer.asciitable.AsciiTable;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Utils {

    private static String getQueryString(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/queries/" + fileName));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        String property = System.getProperty("line.separator");
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(property);
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    private static ResultSet prepareToQuery(String sqlQuery) throws SQLException {
        Connection conn = DriverManager.getConnection(String.format(("jdbc:mysql://%s:%s/%s"), getParameter("ip"), getParameter("port"), getParameter("dataBase")), getParameter("user"), getParameter("password"));
        PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery);
        return preparedStatement.executeQuery();
    }

    private static String getParameter(String parameter) {
        Properties property = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/credentials.properties");
            property.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property.getProperty(parameter);
    }

    public static void outResultQuery(List<String> columns, String sqlFileName) throws IOException, SQLException {
        ResultSet resultSet = Utils.prepareToQuery(Utils.getQueryString(sqlFileName));
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
