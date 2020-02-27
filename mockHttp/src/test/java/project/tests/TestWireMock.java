package project.tests;

import framework.base.BaseTest;
import org.testng.annotations.Test;
import project.steps.Steps;

public class TestWireMock extends BaseTest {

    @Override
    @Test
    public void runTest() {
        String bodyFirstResponse = Steps.sendMappingOneAndCheck();
        Steps.sendMappingTwoAndCheck();
        Steps.sendMappingThreeAndCheck(bodyFirstResponse);
        Steps.sendMappingFourAndCheck();
        Steps.getAllMappings();
        Steps.deleteAllMappings();
    }
}
