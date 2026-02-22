package Bai22_23.testcases;

import Bai22_23.pages.LoginPage;
import common.BaseTest;
import org.testng.annotations.Test;

@SuppressWarnings("ALL")
public class LoginTest extends BaseTest {

    //khai báo đối tượng trang login
    private LoginPage loginPage;
    //cần page nào thì khai báo ra hết đối tượng page đó


    @Test(priority = 1)
    public void testLoginSuccess() {
        loginPage = new LoginPage(driver);

        loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginPageDisplayed();
        loginPage.verifyLoginSuccess();
    }

    @Test(priority = 2)
    public void testLoginFailureWithEmailInvalid() {
        loginPage = new LoginPage(driver);

        loginPage.loginCRM("admin", "123456");

        loginPage.verifyLoginFailureWithEmailOrPasswordInvalid();
    }

    @Test(priority = 3)
    public void testLoginFailureWithPasswordInvalid() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "123");

        loginPage.verifyLoginFailureWithEmailOrPasswordInvalid();
    }

    @Test(priority = 4)
    public void testLoginFailureWithEmailNull() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("", "123456");
        loginPage.verifyLoginFailureWithEmailNull();
    }

    @Test(priority = 5)
    public void testLoginFailureWithPasswordNull() {
        loginPage = new LoginPage(driver);
        loginPage.loginCRM("admin@example.com", "");

        loginPage.verifyLoginFailureWithPasswordNull();
    }

}
