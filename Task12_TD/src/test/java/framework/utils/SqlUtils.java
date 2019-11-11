package framework.utils;

import aquality.selenium.logger.Logger;

import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlUtils {

    private static final Logger logger = Logger.getInstance();

    private static final String urlDataBase = ReaderUtils.getParameter("urlDataBase");
    private static final String ip = ReaderUtils.getParameter("ip");
    private static final String port = ReaderUtils.getParameter("port");
    private static final String dataBase = ReaderUtils.getParameter("dataBase");
    private static final String login = ReaderUtils.getParameter("login");
    private static final String password = ReaderUtils.getParameter("password");

    public static void executeQuery(String sqlQuery) {
        logger.info("execute query to database");
        try {
            DriverManager.getConnection(getUrlDataBase(), login, password).prepareStatement(sqlQuery).executeUpdate();
        } catch (SQLException e) {
            logger.warn("Can't execute query");
        }
    }

    private static String getUrlDataBase() {
        return String.format(("%s//%s:%s/%s"), urlDataBase, ip, port, dataBase);
    }
}