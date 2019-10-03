package project.tests;

import framework.base.BaseTest;
import org.testng.annotations.Test;
import project.steps.BattleShipSteps;

public class TestBattleship extends BaseTest {

    @Override
    @Test
    public void runTest() {
        BattleShipSteps.preparationToStart();
        BattleShipSteps.playingGame();
    }
}
