package project.forms.menus;

import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.IComboBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class FilterForm extends Form {

    private IComboBox startRangeYear = getElementFactory().getComboBox(By.xpath("//span[contains(text(), 'Min')]//following-sibling::div[@class='select']//select[@name='yrId']"), "start range comboBox");
    private IComboBox endRangeYear = getElementFactory().getComboBox(By.xpath("//span[contains(text(), 'Max')]//following-sibling::div[@class='select']//select[@name='yrId']"), "end range comboBox");

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
}
