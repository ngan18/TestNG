package Bai16_ThucHanhCRM;

import common.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

@SuppressWarnings("ALL")
public class Dashboard extends BaseTest {
    @Test
    public void dashboardPage() {
        driver.get("https://crm.anhtester.com/admin/authentication");
        LoginTest loginTest = new LoginTest();
        loginTest.LoginPage();

        // Verify that the "Projects In Progress" number is displayed on the dashboard page
        boolean isProjectsInProgressDisplayed = driver.findElements(By.xpath("//span[normalize-space()=\"Projects In Progress\"]/parent::div/following-sibling::span")).size() > 0;
        Assert.assertTrue(isProjectsInProgressDisplayed, "Projects In Progress number is not displayed");

        String totalProjectsInProgress = driver.findElement(By.xpath("//span[normalize-space()=\"Projects In Progress\"]/parent::div/following-sibling::span")).getText();
        System.out.println("Total Projects In Progress: " + totalProjectsInProgress);

        String totalNotStarted = driver.findElement(By.xpath("//span[normalize-space()=\"Not Started\"]/parent::div/following-sibling::span")).getText();
        System.out.println("Total Not Started: " + totalNotStarted);

        String totalInProgress = driver.findElement(By.xpath("//span[normalize-space()=\"In Progress\"]/parent::div/following-sibling::span")).getText();
        System.out.println("Total In Progress: " + totalInProgress);

        String totalFinished = driver.findElement(By.xpath("//span[normalize-space()=\"Finished\"]/parent::div/following-sibling::span")).getText();
        System.out.println("Total Finished: " + totalFinished);

        String totalOnHold = driver.findElement(By.xpath("//span[normalize-space()=\"On Hold\"]/parent::div/following-sibling::span")).getText();
        System.out.println("Total On Hold: " + totalOnHold);

        String totalCancelled = driver.findElement(By.xpath("//span[normalize-space()=\"Cancelled\"]/parent::div/following-sibling::span")).getText();
        System.out.println("Total Cancelled: " + totalCancelled);

        int totalProjects =  Integer.parseInt(totalInProgress) - Integer.parseInt(totalNotStarted) + Integer.parseInt(totalFinished) + Integer.parseInt(totalOnHold) + Integer.parseInt(totalCancelled);

        Assert.assertEquals(totalProjects, totalProjectsInProgress, "Total Projects In Progress does not match the sum of project statuses");




    }
}
