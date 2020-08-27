package pages

import framework.elements.Button
import framework.elements.Label
import framework.pages.BasePage
import framework.utils.randomInRange
import framework.waitings.waitFor
import models.Field
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions

class MainPage : BasePage(By.xpath("//div[@class='notifications-wrap']"), "Main page") {

    private val btnRandomOpponent = Button(
        By.xpath("//a[@class='battlefield-start-choose_rival-variant-link']"),
        "Random opponent"
    )
    private val btnRandomPlaceShip =
        Button(By.xpath("//ul[@class='placeships']//span"), "Random place ship")
    private val btnStartGame =
        Button(By.xpath("//div[@class='battlefield-start-button']"), "Button start game")
    private val labelGame = Label(
        By.xpath(
            StringBuilder().append("//div[contains(@class, 'game-error') ")
                .append("or contains(@class,'game-over-win') ")
                .append("or contains(@class,'game-over-lose')]").toString()
        ), "Label notification"
    )
    private val emptyCellAttribute = "battlefield-cell__empty"
    private val hitCellAttribute = "battlefield-cell__hit"
    private val attributeField = "class"

    private fun getBtnField(field: Field): Button {
        return Button(
            By.xpath("//div[@class='battlefield battlefield__rival']//tr[${field.row}]//td[${field.col}]"),
            "field ${field.row} ${field.col}"
        )
    }

    fun clickRandomPlaceShipRandomTimes(bound: Int) {
        for (i in 0..randomInRange(bound)) {
            btnRandomPlaceShip.click()
        }
    }

    fun clickRandomOpponent() {
        btnRandomOpponent.click()
    }

    fun clickStartGame() {
        btnStartGame.click()
    }

    fun clickField(field: Field) {
        if (getBtnField(field).getAttribute(attributeField)!!.contains(emptyCellAttribute)) {
            getBtnField(field).click()
        }
    }

    fun isInjureShip(field: Field): Boolean {
        return getBtnField(field).getAttribute(attributeField)!!.contains(hitCellAttribute)
    }

    fun getTextFromLabelGame(): String? {
        return labelGame.getText()
    }

    fun getAttributeFromLabelGame(): String? {
        waitFor(
            ExpectedConditions.visibilityOf(labelGame.getElement()),
            "Wait Label"
        )
        return labelGame.getAttribute(attributeField)
    }

    fun isVisibleLabel(): Boolean {
        return labelGame.isDisplayed()
    }
}