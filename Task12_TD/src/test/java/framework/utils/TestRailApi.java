package framework.utils;

import aquality.selenium.logger.Logger;
import org.json.simple.JSONObject;
import org.testng.ITestResult;
import project.enums.StatusParameter;
import project.projectutils.Requests;

import java.util.HashMap;
import java.util.Map;

public class TestRailApi {

    private static final Logger logger = Logger.getInstance();

    public static void setResult(ITestResult result, String urlImg) throws Throwable {
        logger.info("Set result to testrail");
        if (result.getStatus() == ITestResult.SUCCESS) {
            Requests.addResult(createJsonForSend(StatusParameter.PASSED, urlImg));
        } else if (result.getStatus() == ITestResult.FAILURE) {
            Requests.addResult(createJsonForSend(StatusParameter.FAILED, urlImg));
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
