package project.pages


import framework.form.Form
import org.openqa.selenium.By
import project.form.TopMenu

class MainPage extends Form {
    TopMenu topMenu = new TopMenu()

    MainPage() {
        super("Main Page", By.xpath("//a[@class='_3WG8F _3xBVO']"))
    }
}
