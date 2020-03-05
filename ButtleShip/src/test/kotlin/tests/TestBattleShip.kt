package tests

import base.BaseTest
import org.testng.annotations.Test
import steps.playingGame
import steps.preparationToStart

class TestBattleShip : BaseTest() {

    @Test
    fun runTest() {
        preparationToStart()
        playingGame()
    }
}