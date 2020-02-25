package project.tests;

import framework.base.BaseTest;
import org.testng.annotations.Test;
import project.steps.Steps;

public class TestWireMock extends BaseTest {

    @Override
    @Test
    public void runTest() {
        Steps.sendMappingOneAndCheck();
        Steps.sendMappingTwoAndCheck();
        Steps.sendMappingThree();
        Steps.sendMappingFour();
        Steps.deleteAllMappings();
        Steps.getAllMappings();
    }
}
