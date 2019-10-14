package project.forms.menus;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import project.enums.SideBarItem;

public class SideBar extends Form {

    public SideBar() {
        super(By.xpath("//div[@class='facet-category']"), "Side menu");
    }

    private IButton getBtnSideBar(String sideBarItem) {
        return getElementFactory().getButton(By.xpath(String.format("//li[@class='tab %s']", sideBarItem)), sideBarItem + " button");
    }

    public void clickBtnSideBar(SideBarItem sideBarItem) {
        getBtnSideBar(sideBarItem.getSideBarItem()).click();
    }

    public SideBarSearch getSideBarSearch() {
        return sideBarSearch;
    }

    public SideBarProperties getSideBarProperties() {
        return sideBarProperties;
    }

    private SideBarSearch sideBarSearch = new SideBarSearch();

    private SideBarProperties sideBarProperties = new SideBarProperties();
}