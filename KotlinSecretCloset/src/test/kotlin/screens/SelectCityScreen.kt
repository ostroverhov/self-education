package screens

import enums.CityItem
import framework.elements.Button
import framework.elements.Label
import framework.elements.TextBox
import framework.screens.BaseScreen
import org.openqa.selenium.By

class SelectCityScreen : BaseScreen(By.id("action_bar_root"), "Select city screen") {

    private val btnOkOnAlert: Button =
        Button(By.id("android:id/button1"), "Button Ok on alert label")
    private val lblFirstAvailableCity: Label =
        Label(By.id("tvCityItemName"), "Label first available city")
    private val textBoxSearchCity: TextBox =
        TextBox(By.id("etSearchTest"), "Text box for search city")

    fun clickOkOnAlertLabel() = btnOkOnAlert.click()

    fun inputNameCity(cityItem: CityItem?) {
        textBoxSearchCity.clearAndType(cityItem!!.city)
        selectFirstAvailableCity()
    }

    private fun selectFirstAvailableCity() = lblFirstAvailableCity.click()
}