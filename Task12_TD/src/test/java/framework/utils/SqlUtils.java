package framework.utils;

import aquality.selenium.logger.Logger;

import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlUtils {

    private static final Logger logger = Logger.getInstance();

    public static void executeQuery(String sqlQuery) throws SQLException {
        logger.info("execute query to database");
        DriverManager.getConnection(String.format(("jdbc:mysql://%s:%s/%s"), getCredential("ip"), getCredential("port"), getCredential("dataBase")), getCredential("login"), getCredential("password")).prepareStatement(sqlQuery).executeUpdate();
    }

    private static String getCredential(String parameter) {
        return ReaderUtils.getParameter(parameter);
    }
}
