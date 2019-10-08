package project.steps;

import org.testng.Assert;
import project.models.Field;
import project.models.TemplatesGame;
import project.pages.MainPage;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class BattleShipSteps {

    private static final int rangeForRandomPlaceShips = 15;

    public static void preparationToStart(MainPage mainPage) {
        mainPage.clickRandomOpponent();
        mainPage.clickRandomPlaceShipRandomTimes(rangeForRandomPlaceShips);
        mainPage.clickStartGame();
    }

    public static void playingGame(MainPage mainPage) {
        LinkedHashSet<Field> fields = new TemplatesGame().generateCombinationFieldsTemplate();
        for (Field f : fields) {
            if (mainPage.isInvisibleLabel()) {
                mainPage.clickField(f);
                if (mainPage.isInjureShip(f)) {
                    ArrayList<Field> nextInjuredFields = killShipFirstStage(f, mainPage);
                    if (!nextInjuredFields.isEmpty()) {
                        ArrayList<Field> finallyInjuredFields = killShipNextStage(nextInjuredFields, mainPage);
                        if (!finallyInjuredFields.isEmpty()) {
                            killShipNextStage(finallyInjuredFields, mainPage);
                        }
                    }
                }
            } else getResultGame(mainPage);
        }
    }

    private static ArrayList<Field> killShipFirstStage(Field injureField, MainPage mainPage) {
        ArrayList<Field> nextInjuredFields = new ArrayList<>();
        LinkedHashSet<Field> templateInjuredFields = new TemplatesGame().killShipTemplate(injureField);
        for (Field injuredField : templateInjuredFields) {
            mainPage.clickField(injuredField);
            if (mainPage.isInjureShip(injuredField)) {
                nextInjuredFields.add(injuredField);
            }
        }
        return nextInjuredFields;
    }

    private static ArrayList<Field> killShipNextStage(ArrayList<Field> injuredFields, MainPage mainPage) {
        ArrayList<Field> nextInjuredFields = new ArrayList<>();
        for (Field injuredField : injuredFields) {
            nextInjuredFields.addAll(killShipFirstStage(injuredField, mainPage));
        }
        return nextInjuredFields;
    }

    private static void getResultGame(MainPage mainPage) {
        Assert.assertTrue(mainPage.getAttributeFromLabelGame().contains("game-over-win"), mainPage.getTextFromLabelGame());
    }
}

