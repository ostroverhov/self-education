package project.forms.menus;

import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import aquality.selenium.waitings.ConditionalWait;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FilterForm extends Form {

    private IComboBox startRangeYear = getElementFactory().getComboBox(By.xpath("//span[contains(text(), 'Min')]//following-sibling::div[@class='select']//select[@name='yrId']"), "start range comboBox");
    private IComboBox endRangeYear = getElementFactory().getComboBox(By.xpath("//span[contains(text(), 'Max')]//following-sibling::div[@class='select']//select[@name='yrId']"), "end range comboBox");
    private ILabel filterOverlay = getElementFactory().getLabel(By.xpath("//div[@class='filter-overlay']"), "filter overlay");

    public FilterForm() {
        super(By.className("filter-tabs"), "Filter form");
    }

    private ICheckBox getCheckBoxTrim(String trim) {
        return getElementFactory().getCheckBox(By.xpath(String.format("//li[@id= 'trId']//label[@class = 'checkbox__label ' and contains(text(), '%s')]", trim)), "checkBox " + trim);
    }

    public void clickCheckBoxTrim(String option) {
        getCheckBoxTrim(option).check();
    }

    public void selectYear(String year) {
        startRangeYear.selectByContainingText(year);
        endRangeYear.selectByContainingText(year);
    }

    public void waitInvisibilityFilterOverlay() {
        ConditionalWait.waitFor(ExpectedConditions.invisibilityOf(filterOverlay.getElement()), "invisible filter overlay");
    }
}
