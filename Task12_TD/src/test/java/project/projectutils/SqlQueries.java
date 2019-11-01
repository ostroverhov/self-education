package project.projectutils;

import framework.utils.ReaderUtils;
import framework.utils.ScreenShotUtils;
import project.models.TestModel;

import java.io.IOException;

public class SqlQueries {

    private static final String queryAddTest = "INSERT INTO union_reporting.test (name, status_id, method_name, project_id, session_id, start_time, end_time, env, browser, author_id) VALUES ('%s', %s, '%s', %s, 2, '%s', '%s', '%s', '%s', null);";
    private static final String queryAddLog = "INSERT INTO union_reporting.log (content, is_exception, test_id) VALUES ('%s', 1, %s);";
    private static final String queryAddScreenshot = "INSERT INTO union_reporting.attachment (content, content_type, test_id) VALUES ('%s', 'text/html', %s);";

    public static String getQueryAddTest(String idProject, TestModel testModel) {
        return String.format(queryAddTest, testModel.getName(), testModel.getStatus(), testModel.getMethod(), idProject, testModel.getStartTime(), testModel.getEndTime(), testModel.getEnvironment(), testModel.getBrowser());
    }

    public static String getQueryAddLog(String pathToLogFile, String idTest) throws IOException {
        return String.format(queryAddLog, ReaderUtils.readFile(pathToLogFile), idTest);
    }

    public static String getQueryAddScreenshot(String pathToScreenShot, String idTest) throws IOException {
        return String.format(queryAddScreenshot, ScreenShotUtils.screenShotToString(pathToScreenShot), idTest);
    }
}
