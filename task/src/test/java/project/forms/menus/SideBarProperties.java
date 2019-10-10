package project.forms.menus;

import aquality.selenium.elements.interfaces.IElement;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import project.models.ParametersFurniture;

import java.util.ArrayList;
import java.util.List;

import static aquality.selenium.elements.ElementType.LABEL;
import static framework.utils.RegexpHandler.getParameter;

public class SideBarProperties extends Form {

    private static final String patternHeight = "H[\\d]{1}\\.[\\d]{2}";
    private static final String patternWidth = "W[\\d]{1}\\.[\\d]{2}";
    private static final String patternLength = "D[\\d]{1}\\.[\\d]{2}";

    public SideBarProperties() {
        super(By.id("view-component-info"), "Side bar properties");
    }

    public ParametersFurniture getParametersFurniture() {
        ParametersFurniture parametersFurniture = new ParametersFurniture();
        parametersFurniture.setHeight(getParameter(patternHeight, labelSizeFurniture.getText()).replaceAll("\\D+", ""));
        parametersFurniture.setWidth(getParameter(patternWidth, labelSizeFurniture.getText()).replaceAll("\\D+", ""));
        parametersFurniture.setLength(getParameter(patternLength, labelSizeFurniture.getText()).replaceAll("\\D+", ""));
        return parametersFurniture;
    }

    private By labelSceneInformationLocator = By.xpath("//div[@class='scene']//li//b");
    private final ILabel labelNameFurniture = getElementFactory().getLabel(By.xpath("//p[@class='name']"), "Name furniture");
    private final ILabel labelSizeFurniture = getElementFactory().getLabel(By.xpath("//p[@class='dimensions']"), "Size Furniture");

    public String getNameFurniture() {
        return labelNameFurniture.getText();
    }

    public List<String> getSceneInformation() {
        ArrayList<String> sceneInformation = new ArrayList<>();
        for (IElement element : getElementFactory().findElements(labelSceneInformationLocator, LABEL)) {
            sceneInformation.add(element.getText());
        }
        return sceneInformation;
    }
}