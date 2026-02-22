package Bai20_21_ThucHanhHamXuLiChung.testcases;

import Bai20_21_ThucHanhHamXuLiChung.pages.DashboardPage;
import Bai20_21_ThucHanhHamXuLiChung.pages.LoginPage;
import Bai20_21_ThucHanhHamXuLiChung.pages.ProjectPage;
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
