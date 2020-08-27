package app.pages;

import app.form.TopMenu;
import app.form.TrimCard;
import org.openqa.selenium.By;

public class CompareTrimPage extends BasePage {
    private TrimCard trimCard = new TrimCard();
    private TopMenu topMenu = new TopMenu();

    public CompareTrimPage() {
        super("CompareTrim page", By.xpath("//div[contains(@class,'cell cell-bg grow-2')]"));
    }

    public TrimCard getTrimCard() {
        return trimCard;
    }

    public TopMenu getTopMenu() {
        return topMenu;
    }
}
