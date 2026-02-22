package Bai17_PageObjectModel.testcases;

import Bai17_PageObjectModel.pages.DashboardPage;
import Bai17_PageObjectModel.pages.LoginPage;
import common.BaseTest;
import org.testng.annotations.Test;


public class DashboardTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;


    @Test
    public void testLabelProjectsInProgress() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);

        loginPage.urlCRM();
        loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();

        dashboardPage.verifyDashboardPageDisplayed();
        dashboardPage.verifyTotalProjectsInProgress();
    }
}
