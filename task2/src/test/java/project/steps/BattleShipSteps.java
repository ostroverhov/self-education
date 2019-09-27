package project.steps;

import org.testng.Assert;
import project.models.Field;
import project.models.TemplatesGame;
import project.pages.MainPage;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class BattleShipSteps {

    private static final int rangeForRandomPlaceShips = 15;

    public void preparationToStart() {
        MainPage mainPage = new MainPage();
        mainPage.clickRandomOpponent();
        mainPage.clickRandomPlaceShipRandomTimes(rangeForRandomPlaceShips);
        mainPage.clickStartgame();
    }

    public void playingGame() {
        MainPage mainPage = new MainPage();
        TemplatesGame templatesGame = new TemplatesGame();
        LinkedHashSet<Field> fields = templatesGame.generateCombinationFieldsTemplate();
        for (Field f : fields) {
            if (mainPage.isInvisibleLabel()) {
                mainPage.clickField(f);
                if (mainPage.isInjureShip(f)) {
                    ArrayList<Field> nextInjuredFields = killShipFirstStage(f);
                    if (!nextInjuredFields.isEmpty()) {
                        ArrayList<Field> finallyInjuredFields = killShipNextStage(nextInjuredFields);
                        if (!finallyInjuredFields.isEmpty()) {
                            killShipNextStage(finallyInjuredFields);
                        }
                    }
                }
            } else getResultGame();
        }
    }

    private ArrayList<Field> killShipFirstStage(Field injureField) {
        TemplatesGame templatesGame = new TemplatesGame();
        MainPage mainPage = new MainPage();
        ArrayList<Field> nextInjuredFields = new ArrayList<>();
        LinkedHashSet<Field> templateInjuredFields = templatesGame.killShipTemplate(injureField.getRow(), injureField.getCol());
        for (Field injuredField : templateInjuredFields) {
            mainPage.clickField(injuredField);
            if (mainPage.isInjureShip(injuredField)) {
                nextInjuredFields.add(injuredField);
            }
        }
        return nextInjuredFields;
    }

    private ArrayList<Field> killShipNextStage(ArrayList<Field> injuredFields) {
        TemplatesGame templatesGame = new TemplatesGame();
        MainPage mainPage = new MainPage();
        ArrayList<Field> nextInjuredFields = new ArrayList<>();
        for (Field injuredField : injuredFields) {
            LinkedHashSet<Field> fieldsForKill = templatesGame.killShipTemplate(injuredField.getRow(), injuredField.getCol());
            for (Field fieldForKill : fieldsForKill) {
                mainPage.clickField(injuredField);
                if (mainPage.isInjureShip(injuredField)) {
                    nextInjuredFields.add(fieldForKill);
                }
            }
        }
        return nextInjuredFields;
    }

    private void getResultGame() {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.getAttributeFromLabelGame().contains("game-over-win"), mainPage.getTextFromLabelGame());
    }
}

