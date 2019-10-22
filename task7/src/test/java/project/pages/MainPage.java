package project.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import aquality.selenium.waitings.ConditionalWait;
import framework.utils.RandomNumber;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.models.Field;

public class MainPage extends Form {

    public MainPage() {
        super(By.xpath("//div[@class='notifications-wrap']"), "Main page");
    }

    private final IButton btnRandomOpponent = getElementFactory().getButton(By.xpath("//a[@class='battlefield-start-choose_rival-variant-link']"), "Random opponent");
    private final IButton btnRandomPlaceShip = getElementFactory().getButton(By.xpath("//ul[@class='placeships']//span"), "Random place ship");
    private final IButton btnStartGame = getElementFactory().getButton(By.xpath("//div[@class='battlefield-start-button']"), "Button start game");
    private final ILabel labelGame = getElementFactory().getLabel(By.xpath(new StringBuilder().append("//div[contains(@class, 'rival-leave') ")
            .append("or contains(@class,'game-over-win') ")
            .append("or contains(@class,'game-over-lose') ")
            .append("or contains(@class,'server-error') ")
            .append("or contains(@class,'game-error')]").toString()), "Label notification");
    private static final String emptyCellAttribute = "battlefield-cell__empty";
    private static final String hitCellAttribute = "battlefield-cell__hit";
    private static final String attributeField = "class";

    private IButton getBtnField(Field field) {
        return getElementFactory().getButton(By.xpath(String.format("//div[@class='battlefield battlefield__rival']//tr[%s]//td[%s]", field.getRow(), field.getCol())), "field " + field.getRow() + " " + field.getCol());
    }

    public void clickRandomPlaceShipRandomTimes(int bound) {
        for (int i = 0; i < RandomNumber.randomInRange(bound); i++) {
            btnRandomPlaceShip.click();
        }
    }

    public void clickRandomOpponent() {
        btnRandomOpponent.click();
    }

    public void clickStartGame() {
        btnStartGame.click();
    }

    public void clickField(Field field) {
        if (getBtnField(field).getAttribute(attributeField).contains(emptyCellAttribute)) {
            getBtnField(field).click();
        }
    }

    public boolean isInjureShip(Field field) {
        return getBtnField(field).getAttribute(attributeField).contains(hitCellAttribute);
    }

    public String getTextFromLabelGame() {
        return labelGame.getText();
    }

    public String getAttributeFromLabelGame() {
        ConditionalWait.waitFor(ExpectedConditions.visibilityOf(labelGame.getElement()), "Wait Label");
        return labelGame.getAttribute(attributeField);
    }

    public boolean isInvisibleLabel() {
        return !labelGame.state().isDisplayed();
    }
}
