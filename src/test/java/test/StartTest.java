package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.BpsSberbankHomePagePF;
import step.ActionsMainMenuItemStep;

public class StartTest {

    private static WebDriver driver;

    @BeforeAll
    static void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void FirstTest() {
        new BpsSberbankHomePagePF(driver).openPage();
        new ActionsMainMenuItemStep(driver).clickOnMainMenuItem(driver, "Карты");


    }


    @AfterAll
    static void browserClose() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
        driver = null;
    }
}
