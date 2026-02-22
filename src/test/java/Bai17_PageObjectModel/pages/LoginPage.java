package Bai17_PageObjectModel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage{
    //khai báo driver trong từng trang
    private WebDriver driver;

    //khai báo hàm xây dựng cho từng trang để truyền driver vào
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    // khai báo các đối tượng element của trang login
    private  By headerLogin = By.xpath("//h1[normalize-space()=\"Login\"]");
    private  By checkBoxRememberMe = By.xpath("//input[@id=\"remember\"]");
    private  By linkForgotPassword = By.xpath("//a[normalize-space()=\"Forgot Password?\"]");
    private  By inputEmail = By.xpath("//input[@id=\"email\"]");
    private  By inputPassword = By.xpath("//input[@id=\"password\"]");
    private  By buttonLogin = By.xpath("//button[normalize-space()=\"Login\"]");

    private By errorMessageInvalid = By.xpath("//div[contains(@class, 'alert-danger')]");
    private By errorMessageRequiredEmail = By.xpath("//div[normalize-space()='The Email Address field is required.']");
    private By errorMessageRequiredPassword = By.xpath("//div[normalize-space()='The Password field is required.']");

    private String url = "https://crm.anhtester.com/admin/authentication";

    //khai báo hàm xử lí trong nội bộ login
    public void urlCRM() {
        driver.get(url);
    }
    private void enterEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    private void enterPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    private void clickLoginButton() {
        driver.findElement(buttonLogin).click();
    }

    public void loginCRM(String email, String password) {
        urlCRM();
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
    public void verifyLoginSuccess() {
        boolean isDashboardDisplayed = driver.findElements(By.xpath("//span[normalize-space()=\"Dashboard\"]")).size() > 0;
        Assert.assertTrue(isDashboardDisplayed, "Login failed or not on dashboard page");

    }
    public void verifyLoginFailedEmailOrPassword() {
        boolean isErrorMessageDisplayed = driver.findElements(errorMessageInvalid).size() > 0;
        Assert.assertTrue(isErrorMessageDisplayed, "Error message for invalid login is not displayed");
    }

    public void verifyLoginFailedEmailRequiredNull() {
        boolean isErrorMessageDisplayed = driver.findElements(errorMessageRequiredEmail).size() > 0;
        Assert.assertTrue(isErrorMessageDisplayed, "Error message for required email is not displayed");
    }

    public void verifyLoginFailedPasswordRequiredNull() {
        boolean isErrorMessageDisplayed = driver.findElements(errorMessageRequiredPassword).size() > 0;
        Assert.assertTrue(isErrorMessageDisplayed, "Error message for required password is not displayed");
    }

}

