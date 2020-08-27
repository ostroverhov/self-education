package app.form;

import app.pages.BasePage;
import framework.elements.Button;
import org.openqa.selenium.By;

public class TopMenu extends BasePage {
    public TopMenu() {
        super("Top menu", By.xpath("//ul[@class='_1U4gk']//a[@class='_2Qal_']"));
    }

    private Button getButtonTopMenuMainPage(String nameButton) {
        return new Button(By.xpath(String.format("//ul[@class='_1U4gk']//a[@class='_2Qal_'][contains(text(), '%s')]", nameButton)), nameButton + " button");
    }

    private Button getButtonTopMenu(String nameButton) {
        return new Button(By.xpath(String.format("//ul[@class='global-nav__parent']//a[@class='global-nav__link'][contains(text(),'%s')]", nameButton)), nameButton + " button");
    }

    public void clickOnButtonTopMenuMain(MenuHeaderItem nameButton) {
        getButtonTopMenuMainPage(nameButton.getMenuItem()).clickElement();
    }

    public void clickOnButtonTopMenu(MenuHeaderItem nameButton) {
        getButtonTopMenu(nameButton.getMenuItem()).clickElement();
    }
}
