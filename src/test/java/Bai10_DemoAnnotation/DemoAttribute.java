package Bai10_DemoAnnotation;

import org.testng.annotations.Test;

public class DemoAttribute {

    @Test(enabled = true)
    public void firstTest() {
        System.out.println("First test method");
    }

    @Test(enabled = false)
    private void secondTest() {
        System.out.println("Second test method");
    }

    @Test(enabled = true, description = "Check permission of Admin role")
    private void TC_01_CheckRole() {
        System.out.println("TC_01_CheckRole");
    }

    @Test(timeOut = 3000) //timeout 1 second
    private void TC_02_TimeOut() throws InterruptedException {
        Thread.sleep(2000); //run test delay 2 seconds
        System.out.println("TC_02_TimeOut");
    }

    @Test(enabled = true, description = "Anh Tester Automation Testing")
    public void TC_03_Multi_Attribute() {
        System.out.println("Anh Tester");
    }

}
