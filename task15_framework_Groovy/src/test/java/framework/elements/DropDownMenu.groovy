package framework.elements

import framework.utils.RandomElements
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select

class DropDownMenu extends BaseElement {
    DropDownMenu(def locator, def nameElement) {
        super(locator, nameElement)
    }

    private Select getSelect() {
        return new Select(getElement())
    }

    String getRandomElement() {
        List<WebElement> dropDownElements = getSelect().getOptions()
        int random = RandomElements.getRandom(dropDownElements.size())
        getSelect().selectByVisibleText(dropDownElements.get(random).getText())
        return dropDownElements.get(random).getText()
    }

    void clickSelectElement(String selectElement) {
        getSelect().selectByVisibleText(selectElement)
    }
}
