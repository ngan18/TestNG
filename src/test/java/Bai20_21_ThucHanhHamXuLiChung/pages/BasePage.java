package Bai20_21_ThucHanhHamXuLiChung.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
    private By menuDashboard = By.xpath("//span[normalize-space()=\"Dashboard\"]");
    private By menuProjects = By.xpath("//span[normalize-space()=\"Projects\"]");
    private By menuCustomers = By.xpath("//span[normalize-space()=\"Customers\"]");
    private By menuTasks = By.xpath("//span[normalize-space()=\"Tasks\"]");
    private By menuProposals = By.xpath("//span[normalize-space()=\"Proposals\"]");

    // Hàm để click vào menu Dashboard
    public void clickMenuDashboard() {

        driver.findElement(menuDashboard).click();
    }

    // Hàm để click vào menu Projects
    public ProjectPage clickMenuProjects() {
        driver.findElement(menuProjects).click();
        return new ProjectPage(driver);
    }

    // Hàm để click vào menu Customers
    public CustomerPage clickMenuCustomers() {
        driver.findElement(menuCustomers).click();
        return new CustomerPage(driver);
    }

    //Hàm click vào menu Tasks
    public void clickMenuTasks() {
        By menuTasks = By.xpath("//span[normalize-space()=\"Tasks\"]");
        driver.findElement(menuTasks).click();
        //return new TaskPage(driver);
    }
    //Click vào menu Proposals
    public void clickMenuProposals() {
        driver.findElement(menuProposals).click();
        //return new Proposal(driver);
    }
}
