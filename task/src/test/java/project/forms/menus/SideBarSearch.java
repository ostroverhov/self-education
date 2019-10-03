package project.forms.menus;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import project.enums.SideBarSearchItem;

public class SideBarSearch extends Form {

    public SideBarSearch() {
        super(By.xpath("//li[@class='selected']"), "Side bar search");
    }

    public void clickBtnSideSearch(SideBarSearchItem sideBarSearchItem) {
        getBtnSideBarSearch(sideBarSearchItem.getSideBarSearchItem()).click();
    }

    private IButton getBtnSideBarSearch(String sideBarSearch) {
        return getElementFactory().getButton(By.xpath(String.format("//div[@class='facet-category']//a[contains(text(), '%s')]", sideBarSearch)), sideBarSearch + " button");
    }
}