package Bai17_PageObjectModel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    private WebDriver driver;

    BasePage(WebDriver driver) {
        this.driver = driver;
    }
    private By menuDashboard = By.xpath("//span[normalize-space()=\"Dashboard\"]");
    private By menuProjects = By.xpath("//span[normalize-space()=\"Projects\"]");
    private By menuCustomers = By.xpath("//span[normalize-space()=\"Customers\"]");

    // Hàm để click vào menu Dashboard
    public void clickMenuDashboard() {
        driver.findElement(menuDashboard).click();
    }

    // Hàm để click vào menu Projects
    public void clickMenuProjects() {
        driver.findElement(menuProjects).click();
    }

    // Hàm để click vào menu Customers
    public void clickMenuCustomers() {
        driver.findElement(menuCustomers).click();
    }
}
