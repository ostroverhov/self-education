package project.pages

import framework.form.Form
import org.openqa.selenium.By
import project.form.TopMenu
import project.form.TrimCard

class CompareTrimPage extends Form {
    TrimCard trimCard = new TrimCard()
    TopMenu topMenu = new TopMenu()

    CompareTrimPage() {
        super("CompareTrim page", By.xpath("//div[contains(@class,'cell cell-bg grow-2')]"))
    }
}

