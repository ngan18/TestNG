package Bai19_NavigationPage.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage extends BasePage {
    //khai báo đối tượng WebDriver để tương tác với trình duyệt
    private WebDriver driver;

    //khai báo hàm xây dựng để truyền driver vào trang dashboard
    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By buttonDashboardOptions = By.xpath("//button[@data-toggle=\"dropdown\"]");
    private By totalLabelProjectsInProgress = By.xpath("//div[contains(@class, 'card-body')]//h5[normalize-space()=\"Projects in Progress\"]/following-sibling::p");

    //khai báo hàm xử lí trong nội bộ dashboard
    public void verifyDashboardPageDisplayed() {
        boolean isDashboardDisplayed = driver.findElements(By.xpath("//span[normalize-space()=\"Dashboard\"]")).size() > 0;
        Assert.assertTrue(isDashboardDisplayed, "Not on dashboard page");
    }

    public void verifyTotalProjectsInProgress() {

        String totalProjectsOnDashboard = driver.findElement(totalLabelProjectsInProgress).getText();
        System.out.println("Total Projects in Progress: " + totalProjectsOnDashboard);

        clickMenuProjects();
        // Thực hiện các bước để lấy tổng số dự án từ các trạng thái khác nhau

        ProjectPage projectPage = new ProjectPage(driver);

        Assert.assertEquals(totalProjectsOnDashboard, projectPage.getTotalInProgress()+"/"+projectPage.getTotalProjects(),"failed");
    }


}

