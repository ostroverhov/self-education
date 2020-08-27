package project.pages

import framework.form.Form
import org.openqa.selenium.By
import project.form.InfoSection
import project.form.TopMenu

class CarPage extends Form {
    InfoSection infoSection = new InfoSection()
    TopMenu topMenu = new TopMenu()

    CarPage() {
        super("Car Page", By.xpath("//td[@class='mmy-spec__compare']//a"))
    }
}
