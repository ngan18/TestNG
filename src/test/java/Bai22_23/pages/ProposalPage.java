package Bai22_23.pages;

import org.example.Summary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProposalPage extends BasePage {
    private WebDriver driver;

    private LoginPage loginPage;

    public ProposalPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By buttonDate = By.xpath("//input[@id=\"date\"]");
    private By monthDropdown = By.xpath("//select[@class='ui-datepicker-month']");
    private By yearDropdown = By.xpath("//select[@class='ui-datepicker-year']");
    private By dayOption = By.xpath("//a[text()='15']");


    // select date month year
    public void selectDate(String date) {
        String[] dateParts = date.split("-");
        String day = dateParts[0];
        String month = dateParts[1];
        String year = dateParts[2];


        // Click vào trường ngày để mở calendar
        Summary.clickElement( driver,buttonDate);

        // Chọn năm
        Summary.clickElement( driver,yearDropdown);

        // Chọn tháng
        Summary.clickElement( driver,monthDropdown);

        // Chọn ngày
        Summary.clickElement( driver,dayOption);
    }

}
