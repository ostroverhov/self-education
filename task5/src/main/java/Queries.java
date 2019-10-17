import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Queries {

    public static void minWorkingTimeQuery() throws SQLException, IOException {
        List<String> columns = Arrays.asList("PROJECT", "TEST", "MIN_WORKING_TIME");
        Utils.outResultQuery(columns, "minWorkingTime.sql");
    }

    public static void amountUniqueTest() throws SQLException, IOException {
        List<String> columns = Arrays.asList("PROJECT", "TEST_COUNT");
        Utils.outResultQuery(columns, "amountUniqueTest.sql");
    }

    public static void testsSinceDate() throws SQLException, IOException {
        List<String> columns = Arrays.asList("PROJECT", "TEST", "DATE");
        Utils.outResultQuery(columns, "testsSinceDate.sql");
    }

    public static void amountTestsFromBrowser() throws SQLException, IOException {
        List<String> columns = Collections.singletonList("BROWSER");
        Utils.outResultQuery(columns, "amountTestsFromBrowser.sql");
    }
}