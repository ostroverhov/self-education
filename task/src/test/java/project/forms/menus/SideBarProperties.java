package project.forms.menus;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SideBarProperties extends Form {

    public SideBarProperties() {
        super(By.id("view-component-info"), "Side bar properties");
    }

    private String labelSceneInformationLocator = "//div[@class='scene']//li//b";
    private final ILabel labelNameFurniture = getElementFactory().getLabel(By.xpath("//p[@class='name']"), "Name furniture");
    private final ILabel labelSizeFurniture = getElementFactory().getLabel(By.xpath("//p[@class='dimensions']"), "Size Furniture");
    private final ILabel labelSceneInformation = getElementFactory().getLabel(By.xpath(labelSceneInformationLocator), "Scene information");

    public String getNameFurniture() {
        return labelNameFurniture.getText();
    }

    public String getSizeFurniture() {
        return labelSizeFurniture.getText();
    }

    public List<String> getSceneInformation() {
        ArrayList<String> sceneInformation = new ArrayList<>();
        for (WebElement webelement : labelSceneInformation.getElement().findElements(By.xpath(labelSceneInformationLocator))) {
            sceneInformation.add(webelement.getText());
        }
        return sceneInformation;
    }
}