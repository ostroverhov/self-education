package project.projectutils;

import aquality.selenium.logger.Logger;
import com.google.gson.reflect.TypeToken;
import framework.utils.ApiUtils;
import framework.utils.JsonUtils;
import framework.utils.ReaderUtils;
import framework.utils.RequestUtils;
import project.models.ResponseFromApi;
import project.models.TestModel;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class RequestsApp {

    private static final Logger logger = Logger.getInstance();

    private static final String baseForRequestApi = ReaderUtils.getParameter("urlApi");
    private static final String getToken = "/token/get?variant=";
    private static final String getTests = "/test/get/json?projectId=";
    private static final String encodingToApp = Base64.getEncoder().encodeToString(String.format("%s:%s", ReaderUtils.getParameter("login"), ReaderUtils.getParameter("password")).getBytes());

    public static ResponseFromApi getToken(String variant) {
        logger.info("Get token");
        return ApiUtils.sendPost(RequestUtils.createStringRequest(baseForRequestApi, getToken, variant), "", encodingToApp);
    }

    public static ArrayList<TestModel> getTests(String numberProject) {
        logger.info("Get tests");
        return JsonUtils.jsonToArray(ApiUtils.sendPost(RequestUtils.createStringRequest(baseForRequestApi, getTests, numberProject), "", encodingToApp).getBody(), new TypeToken<List<TestModel>>() {
        }.getType());
    }
}
