package Bai16_ThucHanhCRM;

import common.BaseTest;
import org.example.Summary;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void LoginPage() {
        driver.get("https://crm.anhtester.com/admin/authentication");
        Summary.setText(driver, By.xpath("//input[@id=\"email\"]"), "admin@example.com");
        Summary.setText(driver, By.xpath("//input[@id=\"password\"]"), "123456");

        Summary.clickElement(driver, By.xpath("//button[normalize-space()=\"Login\"]"), 10);

        // Verify that the user is redirected to the dashboard page after successful login

        //ko dung cách này vì nếu dùng cách này mà isDisplayed() có lỗi thì
        // isDisplayed sẽ báo lỗi trước khi assert báo lỗi
        //Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()=\"Dashboard123\"]")).isDisplayed(), "Login failed, not on dashboard page");

        // nên dùng cách này vì nếu dùng cách trên mà isDisplayed() có lỗi thì
        // isDisplayed sẽ báo lỗi trước khi assert báo lỗi
        boolean isDashboardDisplayed = driver.findElements(By.xpath("//span[normalize-space()=\"Dashboard123\"]")).size()>0;
        Assert.assertTrue(isDashboardDisplayed, "Login failed or not on dashboard page");

    }
}
