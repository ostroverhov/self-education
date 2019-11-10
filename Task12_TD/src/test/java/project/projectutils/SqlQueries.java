package project.projectutils;

import aquality.selenium.logger.Logger;
import framework.utils.ReaderUtils;
import framework.utils.ScreenShotUtils;
import framework.utils.SqlUtils;
import project.models.TestModel;

import java.io.IOException;

public class SqlQueries {

    private static final Logger logger = Logger.getInstance();

//    private static final String queryAddTest = "INSERT INTO union_reporting.test (name, status_id, method_name, project_id, session_id, start_time, end_time, env, browser, author_id) VALUES ('%s', %s, '%s', %s, 2, '%s', '%s', '%s', '%s', null);";
//    private static final String queryAddLog = "INSERT INTO union_reporting.log (content, is_exception, test_id) VALUES ('%s', 1, %s);";//todo delete
//    private static final String queryAddScreenshot = "INSERT INTO union_reporting.attachment (content, content_type, test_id) VALUES ('%s', 'image/png', %s);";

    private static final String fileQueryAddTest = "queryAddTest.sql";
    private static final String fileQueryAddLog = "queryAddLog.sql";
    private static final String fileQueryAddScreenshot = "queryAddScreenshot.sql";

    public static String getQueryAddTest(String idProject, TestModel testModel) throws IOException {
        String query = String.format(SqlUtils.getQueryString(fileQueryAddTest), testModel.getName(), testModel.getStatus(), testModel.getMethod(), idProject, testModel.getStartTime(), testModel.getEndTime(), testModel.getEnvironment(), testModel.getBrowser());
        logger.info("create query add test " + query);
        return query;
    }

    public static String getQueryAddLog(String pathToLogFile, String idTest) throws IOException {
        String query = String.format(SqlUtils.getQueryString(fileQueryAddLog), ReaderUtils.readFile(pathToLogFile), idTest);
        logger.info("create query add log " + query);
        return query;
    }

    public static String getQueryAddScreenshot(String pathToScreenShot, String idTest) throws IOException {
        String query = String.format(SqlUtils.getQueryString(fileQueryAddScreenshot), ScreenShotUtils.screenShotToString(pathToScreenShot), idTest);
        logger.info("create query add screenshot " + query);
        return query;
    }
}
