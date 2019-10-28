package framework.utils;

import aquality.selenium.logger.Logger;
import project.datastorage.DataGenerator;
import project.models.*;


public class JsonPlaceholderApi {

    private static final Logger logger = Logger.getInstance();

    private static final String addSuite = "add_suite";
    private static final String getSuite = "get_suite";
    private static final String deleteSuite = "delete_suite";
    private static final String addSection = "add_section";
    private static final String getSection = "get_section";
    private static final String deleteSection = "delete_section";
    private static final String addCase = "add_case";
    private static final String getCase = "get_case";
    private static final String deleteCase = "delete_case";
    private static final String addRun = "add_run";
    private static final String getRun = "get_run";
    private static final String deleteRun = "delete_run";
    private static final String addResult = "add_result_for_case";

    public static Suite createSuite() throws Throwable {
        logger.info("Create suite");
        return addToTestRail(createStringRequest(addSuite, 140), DataGenerator.generateSuite(), Suite.class);
    }

    public static Suite getSuite(int idSuite) throws Throwable {
        logger.info("Get suite");
        return getFromTestRail(createStringRequest(getSuite, idSuite), Suite.class);
    }

    public static Section createSection(int id) throws Throwable {
        logger.info("Create section");
        return addToTestRail(createStringRequest(addSection, 140), DataGenerator.generateSection(id), Section.class);
    }

    public static Section getSection(int idSection) throws Throwable {
        logger.info("Get section");
        return getFromTestRail(createStringRequest(getSection, idSection), Section.class);
    }

    public static Case createCase(int idSection) throws Throwable {
        logger.info("Create case");
        return addToTestRail(createStringRequest(addCase, idSection), DataGenerator.generateCase(idSection), Case.class);
    }

    public static Case getCase(int idCase) throws Throwable {
        logger.info("Get case");
        return getFromTestRail(createStringRequest(getCase, idCase), Case.class);
    }

    public static Run createRun(int idCase) throws Throwable {
        logger.info("Create run");
        return addToTestRail(createStringRequest(addRun, 140), DataGenerator.generateRun(idCase), Run.class);
    }

    public static Run getRun(int idRun) throws Throwable {
        logger.info("Get run");
        return getFromTestRail(createStringRequest(getRun, idRun), Run.class);
    }

    public static Result addResult(int idRun, int idCase) throws Throwable {
        logger.info("Add result");
        return addToTestRail(createStringRequest(addResult, idRun, idCase), DataGenerator.generateResult(), Result.class);
    }

    public static void deleteRun(int idRun) throws Throwable {
        logger.info("Delete run");
        ApiUtils.sendPost(createStringRequest(deleteRun, idRun), "");
    }

    public static void deleteCase(int idCase) throws Throwable {
        logger.info("Delete case");
        ApiUtils.sendPost(createStringRequest(deleteCase, idCase), "");
    }

    public static void deleteSection(int idSection) throws Throwable {
        logger.info("Delete section");
        ApiUtils.sendPost(createStringRequest(deleteSection, idSection), "");
    }

    public static void deleteSuite(int idSuite) throws Throwable {
        logger.info("Delete suite");
        ApiUtils.sendPost(createStringRequest(deleteSuite, idSuite), "");
    }

    private static <T> T addToTestRail(String request, String dataForRequest, Class<T> tClass) throws Throwable {
        return JsonUtils.jsonToObject(ApiUtils.sendPost(request, dataForRequest), tClass);
    }

    private static <T> T getFromTestRail(String request, Class<T> tClass) throws Throwable {
        return JsonUtils.jsonToObject(ApiUtils.sendGet(request), tClass);
    }

    private static String createStringRequest(Object... args) {
        logger.info("Create string request");
        StringBuilder request = new StringBuilder(ReaderUtils.getUrl());
        for (Object argument : args) {
            request.append("/").append(argument);
        }
        return request.toString();
    }
}
