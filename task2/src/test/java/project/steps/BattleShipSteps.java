package project.steps;

import org.testng.Assert;
import project.models.Field;
import project.models.TemplatesGame;
import project.pages.MainPage;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class BattleShipSteps {

    private static final int rangeForRandomPlaceShips = 15;

    private static MainPage getMainPage() {
        return new MainPage();
    }

    public static void preparationToStart() {
        getMainPage().clickRandomOpponent();
        getMainPage().clickRandomPlaceShipRandomTimes(rangeForRandomPlaceShips);
        getMainPage().clickStartGame();
    }

    public static void playingGame() {
        LinkedHashSet<Field> fields = new TemplatesGame().generateCombinationFieldsTemplate();
        for (Field f : fields) {
            if (getMainPage().isInvisibleLabel()) {
                getMainPage().clickField(f);
                if (getMainPage().isInjureShip(f)) {
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

    private static ArrayList<Field> killShipFirstStage(Field injureField) {
        ArrayList<Field> nextInjuredFields = new ArrayList<>();
        LinkedHashSet<Field> templateInjuredFields = new TemplatesGame().killShipTemplate(injureField);
        for (Field injuredField : templateInjuredFields) {
            getMainPage().clickField(injuredField);
            if (getMainPage().isInjureShip(injuredField)) {
                nextInjuredFields.add(injuredField);
            }
        }
        return nextInjuredFields;
    }

    private static ArrayList<Field> killShipNextStage(ArrayList<Field> injuredFields) {
        ArrayList<Field> nextInjuredFields = new ArrayList<>();
        for (Field injuredField : injuredFields) {
            nextInjuredFields.addAll(killShipFirstStage(injuredField));
        }
        return nextInjuredFields;
    }

    private static void getResultGame() {
        Assert.assertTrue(getMainPage().getAttributeFromLabelGame().contains("game-over-win"), getMainPage().getTextFromLabelGame());
    }
}

