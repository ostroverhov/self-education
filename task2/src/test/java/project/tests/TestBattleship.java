package project.tests;

import framework.base.BaseTest;
import org.testng.annotations.Test;
import project.steps.BattleShipSteps;

public class TestBattleship extends BaseTest {

    @Override
    @Test(description = "TestNG project demo test")
    public void runTest() {
        BattleShipSteps battleShipSteps = new BattleShipSteps();
        battleShipSteps.preparationToStart();
        battleShipSteps.playingGame();
    }
}
