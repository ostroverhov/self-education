package project.projectutils;

import aquality.selenium.browser.BrowserManager;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.logger.Logger;
import framework.configurations.Configuration;
import org.openqa.selenium.By;
import project.models.TestModel;

import java.util.ArrayList;
import java.util.List;

import static aquality.selenium.elements.ElementType.LABEL;

public class WebsiteUtils {

    private static final Logger logger = Logger.getInstance();

    public static void refreshPage() {
        logger.info("Refresh page");
        BrowserManager.getBrowser().getDriver().navigate().refresh();
    }

    public static void goToMainPage() {
        logger.info("Open main page");
        BrowserManager.getBrowser().goTo(Configuration.getCurrentEnvironment().getStartUrl());
    }

    public static ArrayList<TestModel> getTestsFromTable(List<IElement> elements) {
        logger.info("Get tests from page");
        ArrayList<TestModel> tests = new ArrayList<>();
        for (int i = 1; i < elements.size(); i++) {
            TestModel testModel = new TestModel();
            testModel.setName(textFromChildElement(elements, i, "//td[1]"));
            testModel.setMethod(textFromChildElement(elements, i, "//td[2]"));
            testModel.setStatus(textFromChildElement(elements, i, "//td[3]"));
            testModel.setStartTime(textFromChildElement(elements, i, "//td[4]"));
            testModel.setEndTime(textFromChildElement(elements, i, "//td[5]"));
            testModel.setDuration(textFromChildElement(elements, i, "//td[6]"));
            if (!testModel.getEndTime().isEmpty()) {
                tests.add(testModel);
            }
        }
        return tests;
    }

    public static ArrayList<String> getNameTests(List<IElement> elements) {
        logger.info("Get names of tests");
        ArrayList<String> tests = new ArrayList<>();
        for (IElement element : elements) {
            tests.add(element.getText());
        }
        return tests;
    }

    private static String textFromChildElement(List<IElement> elements, int numberElement, String locator) {
        logger.info("Get text from element " + numberElement);
        return elements.get(numberElement).findChildElement(By.xpath(locator), LABEL).getText();
    }
}
