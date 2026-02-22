package Bai19_NavigationPage.testcases;

import Bai19_NavigationPage.pages.DashboardPage;
import Bai19_NavigationPage.pages.LoginPage;
import Bai19_NavigationPage.pages.ProjectPage;
import common.BaseTest;
import org.testng.annotations.Test;


public class DashboardTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private ProjectPage projectPage;

    @Test
    public void testLabelProjectsInProgress() {
        loginPage = new LoginPage(driver);

        //liên kết trang Login với Dashboard
        dashboardPage = loginPage.loginCRM();


        dashboardPage.verifyDashboardPageDisplayed();
        dashboardPage.verifyTotalProjectsInProgress();

        //liên kết trang Dashboard với Project
        projectPage = dashboardPage.clickMenuProjects();

    }
}
