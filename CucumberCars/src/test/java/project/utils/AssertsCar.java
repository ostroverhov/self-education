package project.utils;

import org.testng.Assert;
import project.models.Car;

public class AssertsCar {

    public static void assertMakeModelYear(String textPanel, Car car) {
        assertCarParameters(textPanel, car.getMake(), "make");
        assertCarParameters(textPanel, car.getModel(), "model");
        assertCarParameters(textPanel, car.getYear(), "year");
    }

    public static void assertCarParameters(String carParameterFromPage, String carParameter, String nameCarParameter) {
        Assert.assertTrue(carParameterFromPage.contains(carParameter), nameCarParameter + " not match");
    }
}
