package project.forms.menus;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import project.enums.MenuHeaderItem;

public class TopMenu extends Form {

    public TopMenu() {
        super(By.xpath("//ul[@class='_1U4gk']//a[@class='_2Qal_']"), "Top menu");
    }

    private IButton getButtonTopMenuMainPage(String nameButton) {
        return getElementFactory().getButton(By.xpath(String.format("//ul[@class='_1U4gk']//a[@class='_2Qal_'][contains(text(), '%s')]", nameButton)), nameButton + " button");
    }

    private IButton getButtonTopMenu(String nameButton) {
        return getElementFactory().getButton(By.xpath(String.format("//ul[@class='global-nav__parent']//a[@class='global-nav__link'][contains(text(),'%s')]", nameButton)), nameButton + " button");
    }

    public void clickOnButtonTopMenuMain(MenuHeaderItem nameButton) {
        getButtonTopMenuMainPage(nameButton.getMenuItem()).click();
    }

    public void clickOnButtonTopMenu(MenuHeaderItem nameButton) {
        getButtonTopMenu(nameButton.getMenuItem()).click();
    }
}
