package framework.utils;

import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlUtils {

    public static void executeQuery(String sqlQuery) throws SQLException {
        DriverManager.getConnection(String.format(("jdbc:mysql://%s:%s/%s"), getCredential("ip"), getCredential("port"), getCredential("dataBase")), getCredential("login"), getCredential("password")).prepareStatement(sqlQuery).executeUpdate();
    }

    private static String getCredential(String parameter) {
        return ReaderUtils.getParameter(parameter);
    }
}
