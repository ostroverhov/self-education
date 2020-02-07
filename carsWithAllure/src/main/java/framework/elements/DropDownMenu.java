package framework.elements;

import framework.utils.RandomElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownMenu extends BaseElement {
    public DropDownMenu(By locator, String nameElement) {
        super(locator, nameElement);
    }

    private Select getSelect() {
        return new Select(getElement());
    }

    public String getRandomElement() {
        List<WebElement> dropDownElements = getSelect().getOptions();
        int random = RandomElements.getRandom(dropDownElements.size());
        getSelect().selectByVisibleText(dropDownElements.get(random).getText());
        return dropDownElements.get(random).getText();
    }

    public void clickSelectElement(String selectElement) {
        getSelect().selectByVisibleText(selectElement);
    }
}
