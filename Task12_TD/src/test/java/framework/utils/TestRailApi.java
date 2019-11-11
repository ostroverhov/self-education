package framework.utils;

import aquality.selenium.logger.Logger;
import org.json.simple.JSONObject;
import org.testng.ITestResult;
import project.enums.StatusParameter;
import project.projectutils.RequestsTestRail;

import java.util.HashMap;
import java.util.Map;

public class TestRailApi {

    private static final Logger logger = Logger.getInstance();

    public static void setResult(ITestResult result, String urlImg) {
        logger.info("Set result to testrail");
        try {
            if (result.getStatus() == ITestResult.SUCCESS) {
                RequestsTestRail.addResult(createJsonForSend(StatusParameter.PASSED, urlImg));
            } else if (result.getStatus() == ITestResult.FAILURE) {
                RequestsTestRail.addResult(createJsonForSend(StatusParameter.FAILED, urlImg));
            }
        } catch (Throwable throwable) {
            logger.warn("Can't set result to testrail");
        }
    }

    private static String createJsonForSend(StatusParameter statusParameter, String urlImg) {
        logger.info("Create json for send");
        Map<String, String> map = new HashMap<>();
        map.put("status_id", statusParameter.getDescription());
        map.put("comment", urlImg);
        return new JSONObject(map).toString();
    }
}
