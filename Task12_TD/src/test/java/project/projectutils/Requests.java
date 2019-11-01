package project.projectutils;

import aquality.selenium.logger.Logger;
import com.google.gson.reflect.TypeToken;
import framework.utils.ApiUtils;
import framework.utils.JsonUtils;
import framework.utils.ReaderUtils;
import project.models.ResultTest;
import project.models.TestModel;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class Requests {

    private static final Logger logger = Logger.getInstance();

    private static final String baseForRequestApi = "http://localhost:8080/api";
    private static final String baseForTestRail = "https://tr.a1qa.com/index.php?/api/v2/";
    private static final String getToken = "/token/get?variant=";
    private static final String getTests = "/test/get/json?projectId=";
    private static final String addResult = "add_result_for_case";
    private static final String encodingToApp = Base64.getEncoder().encodeToString((ReaderUtils.getParameter("login") + ":" + ReaderUtils.getParameter("password")).getBytes());
    private static final String encodingToTestRail = Base64.getEncoder().encodeToString((ReaderUtils.getParameter("user") + ":" + ReaderUtils.getParameter("passwordTestRail")).getBytes());


    public static String getToken(String variant) throws Throwable {
        logger.info("Get token");
        return ApiUtils.sendPost(createStringRequest(baseForRequestApi, getToken, variant), "", encodingToApp);
    }

    public static ArrayList<TestModel> getTests(String numberProject) throws Throwable {
        logger.info("Get tests");
        return JsonUtils.jsonToArray(ApiUtils.sendPost(createStringRequest(baseForRequestApi, getTests, numberProject), "", encodingToApp), new TypeToken<List<TestModel>>() {
        }.getType());
//        return ApiUtils.sendPost(createStringRequest(getTests, numberProject), "");
    }

    public static ResultTest addResult(String request) throws Throwable {
        logger.info("Add result");
        return JsonUtils.jsonToObject(ApiUtils.sendPost(createStringRequest(baseForTestRail, addResult, "/", ReaderUtils.getParameter("runId"), "/", ReaderUtils.getParameter("caseId")), request, encodingToTestRail), ResultTest.class);
//        return addToTestRail(createStringRequest(addResult, idRun, idCase), request, ResultTest.class);
    }

//    private static <T> T addToTestRail(String request, String dataForRequest, Class<T> tClass) throws Throwable {
//        return JsonUtils.jsonToObject(ApiUtils.sendPost(request, dataForRequest), tClass);
//    }

    private static String createStringRequest(String baseForRequestApi, Object... args) {
        logger.info("Create string request");
        StringBuilder request = new StringBuilder(baseForRequestApi);
        for (Object argument : args) {
            request.append(argument);
        }
        return request.toString();
    }
}
