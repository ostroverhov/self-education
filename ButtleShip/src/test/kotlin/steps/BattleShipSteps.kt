package steps

import framework.utils.Logger
import models.Field
import models.Templates
import org.testng.Assert
import pages.MainPage
import java.util.*

private val rangeForRandomPlaceShips = 15
private val logger: Logger = Logger()

fun preparationToStart() = with(MainPage()) {
    logger.info("Prepare to start")
    clickRandomOpponent()
    clickRandomPlaceShipRandomTimes(rangeForRandomPlaceShips)
    clickStartGame()
}

fun playingGame() = with(MainPage()) {
    logger.info("Playing game")
    Templates().generateCombinationFieldsTemplate()?.forEach() { field ->
        if (isVisibleLabel()) {
            getResultGame()
        } else {
            clickField(field!!)
            if (isInjureShip(field)) {
                killShipFirstStage(field).let { nextInjuredFields ->
                    if (nextInjuredFields.isNotEmpty()) {
                        killShipNextStage(nextInjuredFields).let { finallyInjuredFields ->
                            if (finallyInjuredFields.isEmpty()) {
                                killShipNextStage(finallyInjuredFields)
                            }
                        }
                    }
                }
            }
        }
    }
}

fun killShipFirstStage(injureField: Field?): ArrayList<Field> = with(MainPage()) {
    logger.info("Check fields after first kill field")
    val nextInjuredFields = ArrayList<Field>()
    Templates().killShipTemplate(injureField!!)?.forEach {
        clickField(it)
        if (isInjureShip(it)) {
            nextInjuredFields.add(it)
        }
    }
    return nextInjuredFields
}

private fun killShipNextStage(injuredFields: ArrayList<Field>): ArrayList<Field> = with(ArrayList<Field>()) {
    logger.info("Check fields after second and third kill field")
    injuredFields.forEach { this.addAll(killShipFirstStage(it)) }
    return this
}

fun getResultGame() = with(MainPage()) {
    logger.info("Get result game")
    Assert.assertTrue(
        getAttributeFromLabelGame()!!.contains("game-over-win"),
        getTextFromLabelGame()
    )
}