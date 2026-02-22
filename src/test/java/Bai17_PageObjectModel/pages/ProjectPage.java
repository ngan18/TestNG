package Bai17_PageObjectModel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPage extends BasePage{
    private WebDriver driver;

    public ProjectPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
    private By totalNotStarted = By.xpath("//span[normalize-space()=\"Not Started\"]/parent::div/following-sibling::span");
    private By totalInProgress = By.xpath("//span[normalize-space()=\"In Progress\"]/parent::div/following-sibling::span");
    private By totalFinished = By.xpath("//span[normalize-space()=\"Finished\"]/parent::div/following-sibling::span");
    private By totalOnHold = By.xpath("//span[normalize-space()=\"On Hold\"]/parent::div/following-sibling::span");
    private By totalCancelled = By.xpath("//span[normalize-space()=\"Cancelled\"]/parent::div/following-sibling::span");

     public String getTotalNotStarted() {
        return driver.findElement(totalNotStarted).getText();
    }

    public String getTotalInProgress() {
        return driver.findElement(totalInProgress).getText();
    }

    public String getTotalFinished() {
        return driver.findElement(totalFinished).getText();
    }

    public String getTotalOnHold() {
        return driver.findElement(totalOnHold).getText();
    }

    public String getTotalCancelled() {
        return driver.findElement(totalCancelled).getText();
    }

    public int getTotalProjects() {
        int totalProjects = Integer.parseInt(getTotalInProgress()) + Integer.parseInt(getTotalNotStarted()) + Integer.parseInt(getTotalFinished()) + Integer.parseInt(getTotalOnHold()) + Integer.parseInt(getTotalCancelled());
        return totalProjects;
    }
}
