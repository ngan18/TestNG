package Bai13_Alert_Popup_Iframe;

import common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import java.util.Set;

public class handlePopup extends BaseTest {
    @Test
    public void demoOpenNewTab() throws InterruptedException {
        driver.get("https://anhtester.com");
        Thread.sleep(1000);

        // Mở tab mới
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://google.com");

        Thread.sleep(2000);
    }

    @Test
    public void demoOpenNewWindow() throws InterruptedException {
        driver.get("https://anhtester.com");
        Thread.sleep(1000);

        // Mở cửa sổ mới
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://google.com");
        Thread.sleep(2000);
    }

    @Test
    public void demoNotSwitchToTab() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();
        Thread.sleep(1000);

        //Sau khi chuyển hướng sang Tab mới thì getText cái header
        System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
        Thread.sleep(1000);
        //=> Lỗi NoSuchElementException vì driver vẫn đang ở tab cha ban đầu
    }

    @Test
    public void demoHandlePopupTypeTab() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();
        Thread.sleep(1000);

        // Lưu lại lớp window đầu tiên - mã ID hơi dài, in ra sẽ thấy :)
        String MainWindow = driver.getWindowHandle();
        System.out.println(MainWindow);

        // Lấy tất cả các ID của các cửa sổ đang mở
        Set<String> windows = driver.getWindowHandles();

        // Dùng vòng lặp để duyệt qua từng ID
        for (String window : windows) {

            // Kiểm tra nếu ID nào khác với ID của cửa sổ chính thì switch qua cửa sổ đó
            if (!window.equals(MainWindow)) {
                driver.switchTo().window(window);
                Thread.sleep(1000);
                System.out.println("Đã chuyển đến Tab Window mới");

                //Một số hàm hỗ trợ
                System.out.println(driver.switchTo().window(window).getTitle());
                System.out.println(driver.switchTo().window(window).getCurrentUrl());

                //Sau khi chuyển hướng sang Tab mới thì getText cái header
                System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
                Thread.sleep(1000);

                // Đóng cửa sổ hiện tại sau khi hoàn thành công việc
                driver.close();
            }
        }
        // Quay trở lại cửa sổ chính
        driver.switchTo().window(MainWindow);
        System.out.println("Đã chuyển về lại Tab Window chính" + driver.getCurrentUrl());
        Thread.sleep(2000);
    }

    // CÁCH 2: chủ quan, thường dùng khi chỉ có 1->2 tab/window
    @Test
    public void demoHandlePopupTypeTab_Position() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();
        Thread.sleep(1000);
        // Lưu lại lớp window đầu tiên - mã ID hơi dài, in ra sẽ thấy :)
        String MainWindow = driver.getWindowHandle();
        System.out.println(MainWindow);

        // Lấy tất cả các mã định danh Tab Window.
        Set<String> windows = driver.getWindowHandles();

        // Chuyển sang Tab thứ hai (vị trí 1)
        String firstTab = (String) windows.toArray()[0];
        String secondTab = (String) windows.toArray()[1];

        driver.switchTo().window(secondTab);
        Thread.sleep(1000);
        System.out.println("Đã chuyển đến Tab Window mới");

        // Thực hiện các thao tác trên cửa sổ mới
        System.out.println(driver.switchTo().window(secondTab).getTitle());
        System.out.println(driver.switchTo().window(secondTab).getCurrentUrl());

        //Sau khi chuyển hướng sang Tab mới thì getText cái header
        System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
        Thread.sleep(1000);

        // Đóng cửa sổ hiện tại sau khi hoàn thành công việc
        driver.close();

        // Chuyển hướng về lại tab chính ban đầu (Main Window)
        driver.switchTo().window(MainWindow);
        System.out.println("Đã chuyển về lại Tab Window chính" + driver.getCurrentUrl());
        Thread.sleep(2000);
    }


}
