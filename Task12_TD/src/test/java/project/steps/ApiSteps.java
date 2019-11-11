package project.steps;

import org.testng.Assert;
import project.enums.NameProject;
import project.forms.MainPage;
import project.forms.menus.MenuProjects;
import project.models.ResponseFromApi;
import project.models.TestModel;
import project.projectutils.RequestsApp;

import java.util.ArrayList;

public class ApiSteps {

    private static final String variant = "1";
    private static final String ok = "200";

    public static String getToken() {
        ResponseFromApi responseFromApi = RequestsApp.getToken(variant);
        Assert.assertEquals(responseFromApi.getStatusCode(), ok, "token don't get");
        return responseFromApi.getBody();
    }

    public static ArrayList<TestModel> getTestsFromRequest(NameProject nameProject) {
        MainPage mainPage = new MainPage();
        return RequestsApp.getTests(getMenuProjects(mainPage).getIdProject(nameProject.getNameProject()));
    }

    private static MenuProjects getMenuProjects(MainPage mainPage) {
        return mainPage.getMenuProjects();
    }
}
