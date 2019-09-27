package project.pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import aquality.selenium.waitings.ConditionalWait;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import project.models.Field;

import java.util.Random;

public class MainPage extends Form {

    public MainPage() {
        super(By.xpath("//div[@class='notifications-wrap']"), "Main page");
    }

    private final IButton btnRandomOpponent = getElementFactory().getButton(By.xpath("//a[@class='battlefield-start-choose_rival-variant-link']"), "Random opponent");
    private final IButton btnRandomPlaceShip = getElementFactory().getButton(By.xpath("//ul[@class='placeships']//span"), "Random place ship");
    private final IButton btnStartGame = getElementFactory().getButton(By.xpath("//div[@class='battlefield-start-button']"), "Button start game");
    private final ILabel labelGame = getElementFactory().getLabel(By.xpath("//div[contains(@class, 'notification__rival-leave') or contains(@class,'notification__game-over-win') or contains(@class,'notification__game-over-lose')]"), "Label notification");

    private IButton getBtnField(int row, int col) {
        return getElementFactory().getButton(By.xpath(String.format("//div[@class='battlefield battlefield__rival']//tr[%s]//td[%s]", row, col)), "field " + row + " " + col);
    }

    public void clickRandomPlaceShipRandomTimes(int bound) {
        int random = new Random().nextInt(bound);
        for (int i = 0; i < random; i++) {
            btnRandomPlaceShip.click();
        }
    }

    public void clickRandomOpponent() {
        btnRandomOpponent.click();
    }

    public void clickStartgame() {
        btnStartGame.click();
    }

    public void clickField(Field field) {
        if (getBtnField(field.getRow(), field.getCol()).getAttribute("class").contains("battlefield-cell__empty")) {
            getBtnField(field.getRow(), field.getCol()).click();
        }
    }

    public boolean isInjureShip(Field field) {
        return getBtnField(field.getRow(), field.getCol()).getAttribute("class").contains("battlefield-cell__hit");
    }

    public String getTextFromLabelGame() {
        return labelGame.getText();
    }

    public String getAttributeFromLabelGame() {
        ConditionalWait.waitFor(ExpectedConditions.visibilityOf(labelGame.getElement()), "Wait Label");
        return labelGame.getAttribute("class");
    }

    public boolean isInvisibleLabel() {
        return !labelGame.state().isDisplayed();
    }
}
