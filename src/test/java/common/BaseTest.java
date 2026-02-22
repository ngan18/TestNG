package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseTest {
    public WebDriver driver;
    public SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public void createDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Created Chrome driver");
    }

    @AfterMethod
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
            softAssert.assertAll();
        }
        else {
            System.out.println("Driver was not initialized.");
        }
    }
}
