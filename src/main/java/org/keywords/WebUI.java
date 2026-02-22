package org.keywords;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class WebUI {

    private static int WAIT_TIMEOUT = 10;
    private static double Step_time = 0.5;
    private static int Page_load_timeout = 30;

    private static WebDriver driver;

    public WebUI(WebDriver driver) {
        WebUI.driver = driver;
    }

    public static void logConsole(String message) {
        System.out.println(message);
    }

    public static void sleep(double seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }

    public static void highlightElement(By by) {
        // Highlight the element using JavaScript
        String script = "arguments[0].style.border='3px solid red';";

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, driver.findElement(by));
    }

    public static void highlightElement(By by, String color) {
        // Highlight the element using JavaScript
        String script = "arguments[0].style.border='3px solid " + color + "';";
        ((JavascriptExecutor) driver).executeScript(script, driver.findElement(by));
    }

    //open url
    public static void openURL(String url) {
        driver.get(url);
        logConsole("Opened URL: " + url);
    }

    public static WebElement waitForElementClickable(By by) {

        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT), Duration.ofMillis(500));
            element = wait.until(ExpectedConditions.elementToBeClickable(by));
            highlightElement(by);
            return element;
        } catch (Exception e) {
            logConsole("Element not clickable: " + by);
            Assert.fail("Element not clickable: " + by);
            throw e;
        }
    }

    public static WebElement waitForElementClickable(By by, int seconds) {

        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds), Duration.ofMillis(500));
            element = wait.until(ExpectedConditions.elementToBeClickable(by));
            highlightElement(by);
            return element;
        } catch (Exception e) {
            logConsole("Element not clickable: " + by);
            Assert.fail("Element not clickable: " + by);

            throw e;
        }
    }

    public static WebElement waitForVisibilityOfElement(By by) {

        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT), Duration.ofMillis(500));
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            highlightElement(by);
            return element;
        } catch (Exception e) {
            logConsole("Element not clickable: " + by);
            Assert.fail("Element not clickable: " + by);

            throw e;
        }

    }

    public static WebElement waitForVisibilityOfElement(By by, int seconds) {

        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds), Duration.ofMillis(500));
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            highlightElement(by);
            return element;
        } catch (Exception e) {
            logConsole("Element not clickable: " + by);
            Assert.fail("Element not clickable: " + by);

            throw e;
        }
    }

    public static WebElement waitForpresenceOfElement(By by, int seconds) {

        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds), Duration.ofMillis(500));
            element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
            highlightElement(by);
            return element;
        } catch (Exception e) {
            logConsole("Element not clickable: " + by);
            Assert.fail("Element not clickable: " + by);

            throw e;
        }
    }

    public static WebElement waitForpresenceOfElement(By by) {

        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT), Duration.ofMillis(500));
            element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
            highlightElement(by);
            return element;
        } catch (Exception e) {
            logConsole("Element not clickable: " + by);
            Assert.fail("Element not clickable: " + by);

            throw e;
        }
    }

    //chờ trang load xong mới thao tác tiếp
    public static void waitForPageLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Page_load_timeout));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readyState").equals("complete");
            }
        };
        //Check JS is Ready
        boolean jsReady = wait.until(jsLoad);

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            try {
                wait.until(jsLoad);
            } catch (Throwable e) {
                //noinspection CallToPrintStackTrace
                e.printStackTrace();
                Assert.fail("Timeout waiting for Page Load Request to complete.");
            }
        }
    }

    public static void clickElement(By by) {
        sleep(Step_time);
        waitForElementClickable(by).click();
        WebUI.logConsole("Clicked element: " + by);

    }

    public static void clickElement(By by, int seconds) {
        sleep(Step_time);
        waitForElementClickable(by, seconds).click();
        WebUI.logConsole("Clicked element: " + by);

    }

    public static void setText(By by, String text) {
        sleep(Step_time);
        waitForVisibilityOfElement(by).sendKeys(text);
        WebUI.logConsole("Set text '" + text + "' to element: " + by);

    }

    public static void setText(By by, String text, int seconds) {
        sleep(Step_time);
        waitForVisibilityOfElement(by, seconds).sendKeys(text);
        WebUI.logConsole("Set text '" + text + "' to element: " + by);

    }

    //kiểm tra element có tồn tại không
    public static void waitForElementPresent(By by) {
        try {
            waitForpresenceOfElement(by);
            logConsole("Element is present: " + by);
        } catch (Exception e) {
            logConsole("Element is not present: " + by);
            Assert.fail("Element is not present: " + by);
        }
    }

    //lấy giá trị của web element
    public static WebElement getWebElement(By by) {
        return driver.findElement(by);
    }

    //lấy giá trị của list web element
    public static List<WebElement> getWebElements(By by) {
        return driver.findElements(by);
    }


    //checkElementExist
    public static boolean checkElementExist(By by) {
        try {
            getWebElement(by);
            logConsole("Element exists: " + by);
            return true;
        } catch (Exception e) {
            logConsole("Element does not exist: " + by);
            return false;
        }
    }

    //check list Element Exist
    public static boolean checkListElementExist(By by) {
        try {
            List<WebElement> list_elements = getWebElements(by);
            if (list_elements.size() > 0) {
                logConsole("Elements exist: " + by);
                return true;
            } else {
                logConsole("No elements found: " + by);
                return false;
            }
        } catch (Exception e) {
            logConsole("Error checking elements: " + by);
            return false;
        }
    }

    // Hàm kiểm tra sự tồn tại của phần tử với lặp lại nhiều lần
    public static boolean isElementPresent(By by, int retryCount, int delayInSeconds) {
        for (int i = 0; i < retryCount; i++) {
            try {
                getWebElement(by);
                logConsole("Element is present: " + by);
                return true;
            } catch (Exception e) {
                logConsole("Element not found: " + by + ". Retrying... (" + (i + 1) + "/" + retryCount + ")");
                sleep(delayInSeconds);
            }
        }
        logConsole("Element is not present after " + retryCount + " attempts: " + by);
        return false;
    }

    //cách 2
    // Hàm kiểm tra sự tồn tại của phần tử với lặp lại nhiều lần
    public static boolean checkElementExist(By by, int maxRetries, int waitTimeMillis) {
        int retryCount = 0;

        while (retryCount < maxRetries) {
            try {
                WebElement element = getWebElement(by);
                if (element != null) {
                    System.out.println("Tìm thấy phần tử ở lần thử thứ " + (retryCount + 1));
                    return true; // Phần tử được tìm thấy
                }
            } catch (NoSuchElementException e) {
                System.out.println("Không tìm thấy phần tử. Thử lại lần " + (retryCount + 1));
                retryCount++;
                try {
                    Thread.sleep(waitTimeMillis); // Chờ trước khi thử lại
                } catch (InterruptedException ie) {
                    //noinspection CallToPrintStackTrace
                    ie.printStackTrace();
                }
            }
        }

        // Trả về false nếu không tìm thấy phần tử sau maxRetries lần
        logConsole("Không tìm thấy phần tử sau " + maxRetries + " lần thử.");
        return false;
    }

    public static WebElement waitForElementVisible(By by, int seconds) {
        WebElement element = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds), Duration.ofMillis(500));
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            highlightElement(by);
            return element;
        } catch (Exception e) {
            logConsole("Element not visible: " + by);
            Assert.fail("Element not visible: " + by);

            throw e;
        }

    }

    //getElementText
    public static String getElementText(By by) {
        waitForVisibilityOfElement(by);
        sleep(Step_time);
        logConsole("Get text of element: " + by);

        String text = getWebElement(by).getText();
        logConsole("Text of element: " + text);
        return text;
    }

        //getElementAttribute
    public static String getElementAttribute(By by, String attribute) {
        waitForVisibilityOfElement(by);
        logConsole("Get attribute of element: " + by);

        String value = getWebElement(by).getAttribute(attribute);
        logConsole("==> Attribute value: " + value);
        return value;

    }

        //getElementCssValue
    public static String getElementCssValue(By by, String cssProperty) {
        waitForVisibilityOfElement(by);
        logConsole("Get CSS value of element: " + by);

        String value = getWebElement(by).getCssValue(cssProperty);
        logConsole("==> CSS value: " + value);
        return value;
    }


}

