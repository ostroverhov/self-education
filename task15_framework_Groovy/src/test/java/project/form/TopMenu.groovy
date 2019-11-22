package project.form

import framework.elements.Button
import framework.form.Form
import org.openqa.selenium.By
import project.enums.MenuHeaderItem

class TopMenu extends Form {
    TopMenu() {
        super("Top menu", By.xpath("//ul[@class='_1U4gk']//a[@class='_2Qal_']"))
    }

    private def getButtonTopMenuMainPage(def nameButton) {
        new Button(By.xpath(String.format("//ul[@class='_1U4gk']//a[@class='_2Qal_'][contains(text(), '%s')]", nameButton)), nameButton + " button")
    }

    private def getButtonTopMenu(def nameButton) {
        new Button(By.xpath(String.format("//ul[@class='global-nav__parent']//a[@class='global-nav__link'][contains(text(),'%s')]", nameButton)), nameButton + " button")
    }

    void clickOnButtonTopMenuMain(MenuHeaderItem nameButton) {
        getButtonTopMenuMainPage(nameButton.getMenuItem()).clickElement()
    }

    void clickOnButtonTopMenu(MenuHeaderItem nameButton) {
        getButtonTopMenu(nameButton.getMenuItem()).clickElement()
    }
}
