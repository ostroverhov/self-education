package project.forms.menus;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.forms.Form;
import framework.utils.RegExpUtils;
import org.openqa.selenium.By;
import project.models.TestModel;
import project.projectutils.WebsiteUtils;

import java.util.ArrayList;
import java.util.List;

import static aquality.selenium.elements.ElementType.LABEL;

public class TableTests extends Form {

    private static final String patternGetTestId = "testId=((\\d)+)";

    public TableTests() {
        super(By.xpath("//table[@class='table']//tbody"), "Table Tests");
    }

    public ArrayList<TestModel> getListTests() {
        return WebsiteUtils.getTestsFromTable(getElementFactory().findElements(By.xpath("//table[@class='table']//tr"), LABEL));
    }

    public boolean isPresentTest() {
        return testNameBtn.getElement().isDisplayed();
    }

    public String getTestId() {
        return RegExpUtils.getPartFromString(patternGetTestId, getLastTest().getAttribute("href"));
    }

    public String getNameLastTest() {
        return getLastTest().getText();
    }

    public void clickLastTest() {
        getLastTest().click();
    }

    private final IButton testNameBtn = getElementFactory().getButton(By.xpath("//table[@class='table']//tr//td//a"), "Label test name");

    private final IElement getLastTest() {
        List<IElement> elements = getElementFactory().findElements(By.xpath("//table[@class='table']//tr//td//a[contains(@href,'testInfo')]"), LABEL);
        return elements.get(elements.size() - 1);
    }


}
