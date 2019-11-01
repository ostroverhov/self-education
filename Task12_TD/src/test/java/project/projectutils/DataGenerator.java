package project.projectutils;

import project.models.TestModel;

public class DataGenerator {

    private static final int randomLength = 5;
    private static final int randomStatus = 4;

    public static TestModel generateTestExample() {
        TestModel testModel = new TestModel();
        testModel.setName("KS-405 Verify that Reports tabs can be added");
        testModel.setMethod("com.nexage.tests.smoke.VerifyThatReportsTabsCanBeAdded#xTest");
        testModel.setStatus("1");
        testModel.setStartTime("2016-10-12 20:36:26.0");
        testModel.setEndTime("2016-10-12 20:38:26.0");
        testModel.setBrowser("chrome");
        testModel.setEnv("KuznetsovN");
        return testModel;
//        TestModel testModel = new TestModel();
//        testModel.setName(RandomUtils.generateRandomString(randomLength));
//        testModel.setMethod(RandomUtils.generateRandomString(randomLength));
//        testModel.setStatus(String.valueOf(RandomUtils.randomInRange(1, randomStatus)));
//        testModel.setStartTime("2016-10-12 20:36:26.0");
//        testModel.setEndTime("2016-10-12 20:36:30.0");
//        testModel.setBrowser("chrome");
//        testModel.setEnv("KuznetsovN");
//        return testModel;
    }


}
