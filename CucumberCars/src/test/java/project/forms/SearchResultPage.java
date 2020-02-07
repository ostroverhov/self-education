package project.forms;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import project.forms.menus.FilterForm;

public class SearchResultPage extends Form {

    private FilterForm filterForm = new FilterForm();
    private ILabel labelSearchedCars = getElementFactory().getLabel(By.xpath("//div[@class='shop-srp-listings__listing-container']"), "panel with result of searching");
    private ILabel labelPriceCar = getElementFactory().getLabel(By.xpath("//span[@class='listing-row__price ']"), "panel with price car");

    public SearchResultPage() {
        super(By.className("cars-shop-srp-block"), "Search result page");
    }

    public FilterForm getFilterForm() {
        return filterForm;
    }

    public boolean isDisplayedLabelSearchCar() {
        return labelSearchedCars.state().isDisplayed();
    }

    public String getPriceCar() {
        return labelPriceCar.getText();
    }
}
