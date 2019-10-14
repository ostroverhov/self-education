import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class Queries {

    private static final String MIN_WORKING_TIME = "SELECT project.name AS 'PROJECT', test.name AS 'TEST', MIN(test.end_time-test.start_time) AS 'MIN_WORKING_TIME' FROM test " +
            "INNER JOIN project ON test.project_id=project.id " +
            "GROUP BY project.name, test.name ORDER BY project.name, test.name";
    private static final String AMOUNT_UNIQUE_TEST = "SELECT project.name AS 'PROJECT', COUNT(DISTINCT test.name) AS 'TEST_COUNT' FROM test " +
            "INNER JOIN project ON test.project_id=project.id GROUP BY project.name";
    private static final String TESTS_SINCE_DATE = "SELECT project.name AS 'PROJECT', test.name AS 'TEST', test.start_time AS 'DATE' FROM test " +
            "INNER JOIN project ON test.project_id=project.id WHERE test.start_time >='2015-11-07' " +
            "ORDER BY project.name, test.name";
    private static final String AMOUNT_TESTS_FROM_BROWSER = "SELECT COUNT(test.browser) AS 'BROWSER' FROM test WHERE test.browser = 'chrome' " +
            "UNION SELECT COUNT(test.browser) AS 'BROWSER' FROM test WHERE test.browser = 'firefox'";

    public static void minWorkingTimeQuery() throws SQLException, IOException {
        ResultSet resultSet = prepareToQuery(MIN_WORKING_TIME);
        FileWriter fileWriter = new FileWriter("minWorkingTime.csv");
        while (resultSet.next()) {
            String project = resultSet.getString("PROJECT");
            String test = resultSet.getString("TEST");
            int minWorkingTime = resultSet.getInt("MIN_WORKING_TIME");
            fileWriter.write(project + "\t" + test + "\t" + minWorkingTime + "\n");
        }
        fileWriter.close();
    }

    public static void amountUniqueTest() throws SQLException, IOException {
        ResultSet resultSet = prepareToQuery(AMOUNT_UNIQUE_TEST);
        FileWriter fileWriter = new FileWriter("amountUniqueTest.csv");
        while (resultSet.next()) {
            String project = resultSet.getString("PROJECT");
            int testCount = resultSet.getInt("TEST_COUNT");
            fileWriter.write(project + "\t" + testCount + "\n");
        }
        fileWriter.close();
    }

    public static void testsSinceDate() throws SQLException, IOException {
        ResultSet resultSet = prepareToQuery(TESTS_SINCE_DATE);
        FileWriter fileWriter = new FileWriter("testsSinceDate.csv");
        while (resultSet.next()) {
            String project = resultSet.getString("PROJECT");
            String test = resultSet.getString("TEST");
            Date date = resultSet.getDate("DATE");
            Time time = resultSet.getTime("DATE");
            fileWriter.write(project + "\t" + test + "\t" + date + " " + time + "\n");
        }
        fileWriter.close();
    }

    public static void amountTestsFromBrowser() throws SQLException, IOException {
        ResultSet resultSet = prepareToQuery(AMOUNT_TESTS_FROM_BROWSER);
        FileWriter fileWriter = new FileWriter("amountTestsFromBrowser.csv");
        while (resultSet.next()) {
            int browser = resultSet.getInt("BROWSER");
            fileWriter.write(browser + "\n");
        }
        fileWriter.close();
    }

    private static ResultSet prepareToQuery(String sqlQuery) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/union_reporting", "root", "root");
        PreparedStatement preparedStatement = conn.prepareStatement(sqlQuery);
        return preparedStatement.executeQuery();
    }
}