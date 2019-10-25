package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.HomePageBpsSberbankPF;
import step.MainMenuItemStep;

 class StartTest {

    private static WebDriver driver;

    @BeforeAll
    static void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void FirstTest() {
        new HomePageBpsSberbankPF(driver).openPage();
        new MainMenuItemStep(driver).clickOnMainMenuItem(driver, "Карты");
        Assertions.assertTrue(driver.getTitle().equalsIgnoreCase("ПС-Сбербанк - Выбрать карту"),"Title isn't correct: ["+driver.getTitle()+"]");
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
