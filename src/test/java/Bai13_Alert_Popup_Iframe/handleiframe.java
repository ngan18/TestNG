package Bai13_Alert_Popup_Iframe;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static common.BaseTest.driver;

public class handleiframe {
    @Test
    public void demoHandleIFrame() throws InterruptedException {

        driver.get("https://www.lambdatest.com/selenium-playground/iframe-demo/");
        Thread.sleep(3000);
        System.out.println("IFrame total: " + driver.findElements(By.tagName("iframe")).size());

        //----Switch to content of iframe (Editor)--------
        //cách 1. Thẻ iframe thứ nhất
        driver.switchTo().frame(0);
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//div[@class='rsw-ce']")).getText());

        //1. Switch to Parent WindowHandle
        //Chuyển về nội dung chính không thuộc iframe nào
        driver.switchTo().parentFrame();
        Thread.sleep(1000);

        //2. Switch to iframe icon of Messenger
        driver.switchTo().frame(1); //Thẻ iframe thứ hai
        driver.findElement(By.xpath("//a[normalize-space()='API Reference']")).click();
        //Nhấn icon để ẩn messenger chat đi
        Thread.sleep(2000);

        //3.Chuyển sang iframe nhưng phải thông qua dạng WebElement
        driver.switchTo().frame(driver.findElement(By.xpath("//div[@class='fb_dialog_content']/iframe)[1]")));
        Thread.sleep(2000);

    }
}
