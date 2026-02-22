package Bai13_Alert_Popup_Iframe;

import common.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class handleAlert extends BaseTest {
        @Test
        public void demoHandleAlertAccept() throws InterruptedException {
            driver.get("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
            Thread.sleep(2000);

            //Click vào nút "Click Me" thứ nhất
            driver.findElement(By.xpath("(//button[text()='Click Me'])[1]")).click();
            Thread.sleep(1000);

            //Khởi tạo class Alert
            Alert alert1 = driver.switchTo().alert();
            System.out.println(alert1.getText());
            //Nhấn OK trên Alert
            alert1.accept();

            Thread.sleep(1000);
        }
    @Test
    public void demoHandleAlertDismiss() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
        Thread.sleep(2000);

        //Click vào nút "Click Me" thứ hai
        driver.findElement(By.xpath("(//button[text()='Click Me'])[2]")).click();
        Thread.sleep(1000);

        //Khởi tạo class Alert
        Alert alert2 = driver.switchTo().alert();
        //Dùng hàm dismiss() để từ chối Alert (tương ứng click vào nút Cancel)
        alert2.dismiss();

        Thread.sleep(2000);
    }
    @Test
    public void demoHandleAlertInputText() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground/javascript-alert-box-demo");
        Thread.sleep(2000);

        //Mở Alert Input text, click nút Click Me thứ ba
        driver.findElement(By.xpath("(//button[text()='Click Me'])[3]")).click();
        Thread.sleep(1000);

        //Khởi tạo class Alert
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("Anh Tester Demo Alert");
        alert3.accept();

        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.xpath("//p[@id='prompt-demo']")).getText(),
                "You have entered 'Anh Tester Demo Alert 123' !",
                "Chưa điền được text");

        Thread.sleep(3000);
    }
    @Test
    public void demoHandleAlertInputTextOther() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='promtButton']")).click();
        Thread.sleep(1000);
        //Nhấn sendKeys vào ô text
        driver.switchTo().alert().sendKeys("Anh tester iframe");
        Thread.sleep(1000);
        //Nhấn OK
        driver.switchTo().alert().accept();
        Thread.sleep(1000);

        //Kiểm tra giá trị sendKeys
        String value = driver.findElement(By.xpath("//span[@id='promptResult']")).getText();
        System.out.println("Value = " + value);
        Thread.sleep(1000);
        Assert.assertTrue(value.contains("You entered Anh tester iframe"),"Value is not correct");
        Thread.sleep(1000);
    }
}
