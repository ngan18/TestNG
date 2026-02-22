package Bai20_21_ThucHanhHamXuLiChung.testcases;

import Bai19_NavigationPage.pages.DashboardPage;
import Bai19_NavigationPage.pages.LoginPage;
import Bai20_21_ThucHanhHamXuLiChung.pages.CustomerPage;
import common.BaseTest;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    private LoginPage loginPaget;
    private CustomerPage customerPage;
    private DashboardPage dashboardPage;

    @Test
     public void testAddNewCustomer() throws InterruptedException {
        loginPaget = new LoginPage(driver);
        dashboardPage = loginPaget.loginCRM();

        customerPage = new CustomerPage(driver);

        dashboardPage.clickMenuCustomers();
        customerPage.verifyCustomerPageDisplayed();
        customerPage.clickAddNewCustomerButton();
        customerPage.fillDataNewCustomer("John Doe", "A1", "USD", "Vietnamese", "Vietnam");

        customerPage.clickSaveButton();
        customerPage.verifyAlertMessageSuccessDisplayed();

        customerPage.verifyCustomerDetail("John Doe", "A1", "USD", "Vietnamese", "Vietnam");

    }

}
