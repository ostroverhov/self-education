package project.forms;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import project.forms.menus.TopMenu;
import project.forms.menus.TrimCard;

public class CompareTrimPage extends Form {

    private TrimCard trimCard = new TrimCard();
    private TopMenu topMenu = new TopMenu();

    public CompareTrimPage() {
        super(By.xpath("//div[contains(@class,'cell cell-bg grow-2')]"), "CompareTrim page");
    }

    public TrimCard getTrimCard() {
        return trimCard;
    }

    public TopMenu getTopMenu() {
        return topMenu;
    }
}
