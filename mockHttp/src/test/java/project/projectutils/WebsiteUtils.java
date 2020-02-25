package project.projectutils;

import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.logger.Logger;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static aquality.selenium.elements.ElementType.LABEL;

public class WebsiteUtils {

    private static final Logger logger = Logger.getInstance();

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
