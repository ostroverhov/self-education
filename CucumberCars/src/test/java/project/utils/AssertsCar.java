package project.utils;

import framework.utils.RegExpUtils;
import org.testng.Assert;
import project.models.Car;

public class AssertsCar {
    private static String patternYearCar = "[\\d]*";
    private static String patternModelCar = "[\\S]*$";

    public static void assertMakeModelYear(String textPanel, Car car) {
//        String year = RegExpUtils.getPartFromString(patternYearCar, textPanel,0); //todo
//        String model = RegExpUtils.getPartFromString(patternModelCar, textPanel,0);
//        String make = textPanel.replace(year + " ", "").replace(" " + model, "");
//
//        System.out.println("-------------------------------------" + year + model + "----" + make);
        assertCarParameters(textPanel, car.getMake(), "make");
        assertCarParameters(textPanel, car.getModel(), "model");
        assertCarParameters(textPanel, car.getYear(), "year");
    }

    public static void assertCarParameters(String carParameterFromPage, String carParameter, String nameCarParameter) {
        Assert.assertTrue(carParameterFromPage.contains(carParameter), nameCarParameter + " not match");
    }
}
