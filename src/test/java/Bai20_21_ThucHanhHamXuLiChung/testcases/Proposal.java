package Bai20_21_ThucHanhHamXuLiChung.testcases;

import Bai20_21_ThucHanhHamXuLiChung.pages.DashboardPage;
import Bai20_21_ThucHanhHamXuLiChung.pages.LoginPage;
import Bai20_21_ThucHanhHamXuLiChung.pages.ProposalPage;
import common.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Proposal extends BaseTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProposalPage proposalPage;
    private DashboardPage dashboardPages;

    @Test
    public void testProposal() {

        loginPage = new LoginPage(driver);
        dashboardPages = loginPage.loginCRM();
        loginPage.verifyLoginSuccess();

        proposalPage = new ProposalPage(driver);
        proposalPage.clickMenuProposals();
        proposalPage.selectDate("15-2-2021");

    }
}
