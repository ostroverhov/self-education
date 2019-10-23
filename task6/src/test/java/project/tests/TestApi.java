package project.tests;

import framework.base.BaseTest;
import org.testng.annotations.Test;
import project.models.User;
import project.steps.StepsApi;

public class TestApi extends BaseTest {

    @Override
    @Test()
    public void runTest() throws Throwable {
        StepsApi.getAllPosts();
        StepsApi.getPostByNumber();
        StepsApi.getPostNotExist();
        StepsApi.setPost();
        User testUser = StepsApi.getAllUsers();
        StepsApi.getUserByNumber(testUser);
    }
}
