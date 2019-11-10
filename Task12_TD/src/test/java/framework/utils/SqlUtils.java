package framework.utils;

import aquality.selenium.logger.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlUtils {

    private static final Logger logger = Logger.getInstance();

    private static final String pathToSqlQuery = "src/test/resources/sqlqueries/";

    public static String getQueryString(String fileName) throws IOException {
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

    public static void executeQuery(String sqlQuery) throws SQLException {
        logger.info("execute query to database");
        DriverManager.getConnection(String.format(("jdbc:mysql://%s:%s/%s"), getCredential("ip"), getCredential("port"), getCredential("dataBase")), getCredential("login"), getCredential("password")).prepareStatement(sqlQuery).executeUpdate();
    }

    private static String getCredential(String parameter) {
        return ReaderUtils.getParameter(parameter);
    }
}
