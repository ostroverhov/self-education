package steps

import aquality.selenium.logger.Logger
import enums.CityItem
import screens.SelectCityScreen

private val selectCityScreen = SelectCityScreen()
private val logger = Logger.getInstance()

fun clickBtnOkOnAlertLabel() {
    logger.info("Click button 'Ok' on alert label")
    selectCityScreen.clickOkOnAlertLabel()
}

fun selectCityByName(cityItem: CityItem?) {
    logger.info("Select city by name")
    selectCityScreen.inputNameCity(cityItem)
}