package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Summary {
    public static WebDriver driver;

    public Summary(WebDriver driver) {
        this.driver = driver;
    }

    public static void highlightElement(WebDriver driver, WebElement element) {
        // Highlight the element using JavaScript
        String script = "arguments[0].style.border='3px solid red';";

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, element);
    }

    public static void highlightElement(WebDriver driver, WebElement element, String color) {
        // Highlight the element using JavaScript
        String script = "arguments[0].style.border='3px solid " + color + "';";
        ((JavascriptExecutor) driver).executeScript(script, element);
    }

    public static void setText(WebDriver driver, By by, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        element.clear();
        element.sendKeys(text);
        //driver.findElement(by).sendKeys(text);
    }

    public static void clickElement(WebDriver driver, By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //driver.findElement(by).click();
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        highlightElement(driver,element);
        element.click();


        // 1+2 gộp = wait.until(ExpectedConditions.elementToBeClickable(by)).click();
        //hoặc WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by)).click();

        //cách này để tránh đợi implicitWait rồi mới đợi explicitWait.
        //vì elementToBeClickable trả về webElement nên dùng được các chức năng của nó
        // như click, senkeys,....
    }
    public static void clickElement(WebDriver driver, By by, int second){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(second));
        WebElement element =  wait.until(ExpectedConditions.elementToBeClickable(by));
        element.click();

    }
    public void exitsElement(){
        boolean isDashboardDisplayed = driver.findElements(By.xpath("//span[normalize-space()=\"Dashboard123\"]")).size()>0;
        Assert.assertTrue(isDashboardDisplayed, "Login failed or not on dashboard page");

    }
}
