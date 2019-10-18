import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, IOException {
        Queries.minWorkingTimeQuery();
        Queries.amountUniqueTest();
        Queries.testsSinceDate();
        Queries.amountTestsFromBrowser();
    }
}