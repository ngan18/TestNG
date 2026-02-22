package Bai22_23.testcases;

import Bai22_23.pages.DashboardPage;
import Bai22_23.pages.LoginPage;
import Bai22_23.pages.ProposalPage;
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
