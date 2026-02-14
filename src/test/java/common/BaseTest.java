package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    public static SoftAssert softAssert = new SoftAssert();

    @BeforeMethod
    public static void createDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Created Chrome driver");
    }

    @AfterMethod
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            System.out.println("Closed Chrome driver");
            softAssert.assertAll();
        }
    }
}
