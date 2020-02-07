package project.forms.menus;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import framework.utils.RegExpUtils;
import org.openqa.selenium.By;

public class TrimCard extends Form {

    private ILabel labelEngine = getElementFactory().getLabel(By.xpath("//div[contains(@class,'cell cell-bg grow-2')]"), "label Engine");
    private ILabel labelTransmission = getElementFactory().getLabel(By.xpath("//div[contains(@class,'cell grow-2')]"), "label transmission");
    private ILabel titleLabel = getElementFactory().getLabel(By.className("trim-header__title"), "title of label");
    private ILabel nameTrimLabel = getElementFactory().getLabel(By.className("cui-accordion-section__title"), "name trim label");
    private String patternGetNameTrim = "Trim: (.+)";

    public TrimCard() {
        super(By.xpath("//div[contains(@class,'cell cell-bg grow-2')]"), "Trim card");
    }

    public String getTextPanelEngine() {
        return labelEngine.getText();
    }

    public String getTextPanelTrans() {
        return labelTransmission.getText();
    }

    public String getTextTitleLabel() {
        return titleLabel.getText();
    }

    public String getNameTrim() {
        return RegExpUtils.getPartFromString(patternGetNameTrim, nameTrimLabel.getText());
    }
}
