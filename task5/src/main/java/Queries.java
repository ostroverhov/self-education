import java.io.IOException;
import java.sql.SQLException;

public class Queries {

    public static void minWorkingTimeQuery() throws SQLException, IOException {
        QueryUtils.outResultQuery("minWorkingTime.sql");
    }

    public static void amountUniqueTest() throws SQLException, IOException {
        QueryUtils.outResultQuery("amountUniqueTest.sql");
    }

    public static void testsSinceDate() throws SQLException, IOException {
        QueryUtils.outResultQuery("testsSinceDate.sql");
    }

    public static void amountTestsFromBrowser() throws SQLException, IOException {
        QueryUtils.outResultQuery("amountTestsFromBrowser.sql");
    }
}