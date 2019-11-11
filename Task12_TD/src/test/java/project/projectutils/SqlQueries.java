package project.projectutils;

import aquality.selenium.logger.Logger;
import framework.utils.ReaderUtils;
import framework.utils.ScreenShotUtils;
import project.models.TestModel;

public class SqlQueries {

    private static final Logger logger = Logger.getInstance();

    private static final String fileQueryAddTest = "src/test/resources/sqlqueries/queryAddTest.sql";
    private static final String fileQueryAddLog = "src/test/resources/sqlqueries/queryAddLog.sql";
    private static final String fileQueryAddScreenshot = "src/test/resources/sqlqueries/queryAddScreenshot.sql";

    public static String getQueryAddTest(String idProject, TestModel testModel) {
        String query = String.format(ReaderUtils.readFile(fileQueryAddTest), testModel.getName(), testModel.getStatus(), testModel.getMethod(), idProject, testModel.getStartTime(), testModel.getEndTime(), testModel.getEnvironment(), testModel.getBrowser());
        logger.info("create query add test " + query);
        return query;
    }

    public static String getQueryAddLog(String pathToLogFile, String idTest) {
        String query = String.format(ReaderUtils.readFile(fileQueryAddLog), ReaderUtils.readFile(pathToLogFile), idTest);
        logger.info("create query add log " + query);
        return query;
    }

    public static String getQueryAddScreenshot(String pathToScreenShot, String idTest) {
        String query = String.format(ReaderUtils.readFile(fileQueryAddScreenshot), ScreenShotUtils.screenShotToString(pathToScreenShot), idTest);
        logger.info("create query add screenshot " + query);
        return query;
    }
}
