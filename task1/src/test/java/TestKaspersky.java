import app.form.DownloadPanel;
import app.models.ModelMessage;
import app.pages.BasePage;
import app.pages.Dashboard;
import app.pages.MainPage;
import app.pages.MyDownloads;
import app.projectUtils.EmailUtils;
import framework.utils.MyLogger;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static app.form.NavigationPanelItem.DOWNLOADS;


public class TestKaspersky extends BaseTest {

    @Test
    @Parameters(value = {"email", "password", "nameSystem", "nameProduct"})
    public void testKaspersky(String email, String password, String nameSystem, String nameProduct) {
        MyLogger.step("Open and check main page");
        MainPage mainPage = new MainPage();
        assertPage(mainPage);
        mainPage.getHeader().clickOnButtonSignIn();

        MyLogger.step("Login");
        mainPage.getSignInForm().login(email, password);
        Dashboard dashboard = new Dashboard();
        assertPage(dashboard);

        MyLogger.step("Go to page downloads");
        dashboard.getNavigationPanel().clickButtonNavigationPanel(DOWNLOADS);

        MyDownloads myDownloads = new MyDownloads();
        assertPage(myDownloads);

        MyLogger.step("Select system");
        myDownloads.getTabPanel().clickButtonTabPanel(nameSystem);

        MyLogger.step("Check send by email link with product");
        myDownloads.getProductsCarousel().clickButtonDownloadCarousel(nameProduct);
        DownloadPanel downloadPanel = myDownloads.getDownloadPanel();
        downloadPanel.clickButtonSendByEmail();
        Assert.assertEquals(downloadPanel.getEmailFromInputField(), email, "email not match");
        downloadPanel.inputCaptcha();
        downloadPanel.clickButtonSend();
        EmailUtils.waitMessage(email, password);
        ModelMessage modelMessage = EmailUtils.searchEmail(email, password);
        Assert.assertTrue(modelMessage.getSubject().contains(nameProduct), "name product isn't correct");
        Assert.assertTrue(modelMessage.getBody().contains(nameSystem), "name system isn't correct");
    }

    private void assertPage(BasePage page) {
        Assert.assertTrue(page.isPresentPage(), page.getNamePage() + " not found");
    }


}