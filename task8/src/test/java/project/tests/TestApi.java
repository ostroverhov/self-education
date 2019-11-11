package project.tests;

import framework.base.BaseTest;
import org.testng.annotations.Test;
import project.models.Catalog;
import project.steps.StepsApi;

public class TestApi extends BaseTest {

    @Override
    @Test()
    public void runTest() throws Throwable {
        Catalog catalog = StepsApi.getAllBook();
        StepsApi.compareMaxMinPrice(catalog);
    }
}
