package AddNewCustomer;

import LocatorCRM.LocatorsCRM;
import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class AddNewCustomers extends BaseTest {
    public  void loginCRM() {
        driver.get(LocatorsCRM.url);
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputEmail)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputPassword)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorsCRM.buttonLogin)).click();
        // Verify login success
    }

    public void openNewCustomerPage() {
        driver.findElement(By.xpath(LocatorsCRM.menuCustomers)).click();
        driver.findElement(By.xpath(LocatorsCRM.buttonNewCustomer)).click();
        // Verify New Customer page is opened
    }

    public void addNewCustomer(String customerName) throws InterruptedException {
        driver.findElement(By.xpath(LocatorsCRM.inputCompany)).sendKeys(customerName);
        driver.findElement(By.xpath(LocatorsCRM.inputVatNumber)).sendKeys("10");
        driver.findElement(By.xpath(LocatorsCRM.inputPhone)).sendKeys("0912345678");
        driver.findElement(By.xpath(LocatorsCRM.inputWebsite)).sendKeys("https://anhtester.com");

        driver.findElement(By.xpath(LocatorsCRM.dropdownGroups)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputSearchGroups)).sendKeys("VIP", Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.dropdownGroups)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCRM.dropdownCurrency)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCurrency)).sendKeys("USD", Keys.ENTER);
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCRM.dropdownLanguage)).click();
        Thread.sleep(1000);
        //driver.findElement(By.xpath(LocatorsCRM.optionLanguage)).click();
        //driver.findElement(By.xpath(LocatorsCRM.selectXpathLanguage("German"))).click();

        String languageXpath = String.format(LocatorsCRM.optionLanguageDynamic, "Vietnamese", 1);
        System.out.println("Language XPath: " + languageXpath);

        driver.findElement(By.xpath(languageXpath)).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCRM.inputAddress)).sendKeys("Omon");
        driver.findElement(By.xpath(LocatorsCRM.inputCity)).sendKeys("Can Tho");
        driver.findElement(By.xpath(LocatorsCRM.inputState)).sendKeys("Can Tho");
        driver.findElement(By.xpath(LocatorsCRM.inputZip)).sendKeys("12345");

        driver.findElement(By.xpath(LocatorsCRM.dropdownCountry)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCountry)).sendKeys("Vietnam", Keys.ENTER);

        Thread.sleep(1000);

        driver.findElement(By.xpath(LocatorsCRM.buttonSave)).click();

        Thread.sleep(2000);
    }

    public void searchCustomer(String customerName) throws InterruptedException {
        driver.findElement(By.xpath(LocatorsCRM.menuCustomers)).click();
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCustomer)).clear();
        driver.findElement(By.xpath(LocatorsCRM.inputSearchCustomer)).sendKeys(customerName);
        Thread.sleep(2000);

        String firstRowCustomer = driver.findElement(By.xpath(LocatorsCRM.firstRowItemCustomer)).getText();
        System.out.println("First row customer: " + firstRowCustomer);
    }

    public static void main(String[] args) throws InterruptedException {
//        createDriver();
//
//        loginCRM();
//        //openNewCustomerPage();
//        driver.findElement(By.xpath(LocatorsCRM.menuCustomers)).click();
//
//        int customerTotal = Integer.parseInt(driver.findElement(By.xpath("//span[normalize-space()='Total Customers']/preceding-sibling::span")).getText());
//        System.out.println("Total Customers: " + customerTotal);
//
//        driver.findElement(By.xpath(LocatorsCRM.buttonNewCustomer)).click();
//
//
//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//        String formatted = now.format(formatter);
//        System.out.println("Định dạng: " + formatted);
//
//        addNewCustomer("Test Company " + formatted);
//        searchCustomer("Test Company " + formatted);
//
//        int customerTotalAfterAddNew = Integer.parseInt(driver.findElement(By.xpath("//span[normalize-space()='Total Customers']/preceding-sibling::span")).getText());
//        System.out.println("Total Customers After Add New: " + customerTotalAfterAddNew);
//
//        if (customerTotalAfterAddNew == (customerTotal+1)) {
//            System.out.println("Customer total is correct!");
//        } else {
//            System.out.println("Failed Customer total is correct. Not equal to " + (customerTotal + 1));
//        }
//
//        closeDriver();
    }
}
