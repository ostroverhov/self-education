package project.tests;

import framework.base.BaseTest;
import org.testng.annotations.Test;
import project.pages.MainPage;
import project.steps.BattleShipSteps;

public class TestBattleship extends BaseTest {

    @Override
    @Test
    public void runTest() {
        MainPage mainPage = new MainPage();
        BattleShipSteps.preparationToStart(mainPage);
        BattleShipSteps.playingGame(mainPage);
    }
}
