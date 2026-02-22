package Bai20_21_ThucHanhHamXuLiChung.testcases;

import Bai20_21_ThucHanhHamXuLiChung.pages.LoginPage;
import common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    //khai báo đối tượng trang login
    private LoginPage loginPage;
    //cần page nào thì khai báo ra hết đối tượng page đó

    @Test
    public void testLoginSucceed() {

        //khởi tạo đối tượng trang login
        loginPage = new LoginPage(driver);

        loginPage.urlCRM();
        loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();

    }

    @Test
    public void testLoginFailedEmail() {

        //khởi tạo đối tượng trang login
        loginPage = new LoginPage(driver);

        loginPage.urlCRM();
        loginPage.loginCRM("admin123@example", "123456");
        loginPage.verifyLoginFailedEmailOrPassword();
    }
    @Test
    public void testLoginFailedPassword() {

        //khởi tạo đối tượng trang login
        loginPage = new LoginPage(driver);

        loginPage.urlCRM();
        loginPage.loginCRM("admin@example.com", "1456");
        loginPage.verifyLoginFailedEmailOrPassword();
    }

    @Test
    public void testLoginEmailNull() {

        //khởi tạo đối tượng trang login
        loginPage = new LoginPage(driver);

        loginPage.urlCRM();
        loginPage.loginCRM("", "123456");
        loginPage.verifyLoginFailedEmailRequiredNull();
    }
    @Test
    public void testLoginPasswordNull() {

        //khởi tạo đối tượng trang login
        loginPage = new LoginPage(driver);

        loginPage.urlCRM();
        loginPage.loginCRM("admin@example.com", "");
        loginPage.verifyLoginFailedPasswordRequiredNull();
    }
}
