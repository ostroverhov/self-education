package project.steps;

import framework.utils.JsonPlaceholderApi;
import framework.utils.RandomUtils;
import org.testng.Assert;
import project.models.*;

public class StepsApi {


    public static void randomTest() {
        Assert.assertTrue(RandomUtils.generateRandomBoolean());
    }

    public static Suite createSuite() throws Throwable {
        return JsonPlaceholderApi.createSuite();
    }

    public static Suite getSuite(int idSuite) throws Throwable {
        return JsonPlaceholderApi.getSuite(idSuite);
    }

    public static Section createSection(int suiteId) throws Throwable {
        return JsonPlaceholderApi.createSection(suiteId);
    }

    public static Section getSection(int idSection) throws Throwable {
        return JsonPlaceholderApi.getSection(idSection);
    }

    public static Case createCase(int idSection) throws Throwable {
        return JsonPlaceholderApi.createCase(idSection);
    }

    public static Case getCase(int idCase) throws Throwable {
        return JsonPlaceholderApi.getCase(idCase);
    }

    public static Run createRun(int idSection) throws Throwable {
        return JsonPlaceholderApi.createRun(idSection);
    }

    public static Run getRun(int idCase) throws Throwable {
        return JsonPlaceholderApi.getRun(idCase);
    }

    public static Result addResult(int idRun, int idCase) throws Throwable {
        return JsonPlaceholderApi.addResult(idRun, idCase);
    }

    public static Result getResult(int idRun, int idCase) throws Throwable {
        return JsonPlaceholderApi.getResult(idRun, idCase);
    }


//    public static String sendGetSections() throws Throwable {
//        return ApiUtils.sendGet("https://tr.a1qa.com/index.php?/api/v2/get_sections/140&suite_id=11515");
//    }

}
