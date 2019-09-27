package framework.baseentity;

import framework.elements.Panel;
import org.openqa.selenium.By;

public abstract class BasePage {

    private String namePage;
    private By locator;

    public BasePage(String namePage, By locator) {
        this.namePage = namePage;
        this.locator = locator;
    }

    public boolean isPresentPage() {
        return new Panel(locator, namePage).isDisplayedElement();
    }

    public String getNamePage() {
        return namePage;
    }

    public String getFullElementName(String nameElement) {
        return nameElement + " on " + namePage;
    }
}
