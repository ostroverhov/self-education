import app.form.DownloadPanel;
import app.models.ModelMessage;
import app.pages.DashboardPage;
import app.pages.MainPage;
import app.pages.MyDownloadsPage;
import framework.baseentity.BasePage;
import framework.utils.EmailUtils;
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
        DashboardPage dashboardPage = new DashboardPage();
        assertPage(dashboardPage);

        MyLogger.step("Go to page downloads");
        dashboardPage.getNavigationPanel().clickButtonNavigationPanel(DOWNLOADS);

        MyDownloadsPage myDownloadsPage = new MyDownloadsPage();
        assertPage(myDownloadsPage);

        MyLogger.step("Select system");
        myDownloadsPage.getTabPanel().clickButtonTabPanel(nameSystem);

        MyLogger.step("Check send by email link with product");
        myDownloadsPage.getProductsCarousel().clickButtonDownloadCarousel(nameProduct);
        DownloadPanel downloadPanel = myDownloadsPage.getDownloadPanel();
        downloadPanel.clickButtonSendByEmail();
        Assert.assertEquals(downloadPanel.getEmailFromInputField(), email, "email not match");
        downloadPanel.inputCaptcha();
        downloadPanel.clickButtonSend();
        EmailUtils.waitMessageFromEmail(email, password);
        ModelMessage modelMessage = EmailUtils.getLastEmail(email, password);
        Assert.assertTrue(modelMessage.getSubject().contains(nameProduct), "name product isn't correct");
        Assert.assertTrue(modelMessage.getBody().contains(nameSystem), "name system isn't correct");
    }

    private void assertPage(BasePage page) {
        Assert.assertTrue(page.isPresentPage(), page.getNamePage() + " not found");
    }
}