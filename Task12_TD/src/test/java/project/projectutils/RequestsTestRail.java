package project.projectutils;

import aquality.selenium.logger.Logger;
import framework.utils.ApiUtils;
import framework.utils.JsonUtils;
import framework.utils.ReaderUtils;
import framework.utils.RequestUtils;
import project.models.ResultTest;

import java.util.Base64;

public class RequestsTestRail {

    private static final Logger logger = Logger.getInstance();

    private static final String addResult = "add_result_for_case";
    private static final String encodingToTestRail = Base64.getEncoder().encodeToString(String.format("%s:%s", ReaderUtils.getParameter("user"), ReaderUtils.getParameter("passwordTestRail")).getBytes());

    public static ResultTest addResult(String request) {
        logger.info("Add result");
        return JsonUtils.jsonToObject(ApiUtils.sendPost(RequestUtils.createStringRequest(ReaderUtils.getParameter("testRailApi"), addResult, "/", ReaderUtils.getParameter("runId"), "/", ReaderUtils.getParameter("caseId")), request, encodingToTestRail).getBody(), ResultTest.class);
    }
}