package package1;

import org.testng.annotations.Test;

import java.time.LocalDateTime;

public class firstClass {
    @Test
    public void firstTest() {
        System.out.println("First test method");
    }

    @Test
    public void secondTest() {
        System.out.println("Second test method");

        // Ví dụ trong một phương thức:
        System.out.println("Current time: " + LocalDateTime.now());
    }

    @Test
    public void thirdTest() {
        System.out.println("Third test method");
    }

    @Test
    public void fourthTest() {
        System.out.println("Fourth test method");
    }

}
