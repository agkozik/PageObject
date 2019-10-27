package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.DropDownMainMenu;
import page.HomePageBpsSberbankPF;
import page.SberBankOnline;
import step.DropDownItemStep;
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
        DropDownMainMenu dropDownMainMenu = new MainMenuItemStep(driver).clickOnMainMenuItem(driver, "Карты");

//        for (WebElement el:dropDownMainMenu.getHeaderDropDownMainMenu()) {
//            System.out.println(el.getText());
//        }
//
//        for (WebElement el:dropDownMainMenu.getItem1DropDownMainMenu()) {
//            System.out.println("\t"+el.getText());
//        }
//
//        for (WebElement el:dropDownMainMenu.getItem2DropDownMainMenu()) {
//            System.out.println("\t\t"+el.getText());
//        }

        Assertions.assertTrue(driver.getTitle().equalsIgnoreCase("БПС-Сбербанк - Выбрать карту"), "Title isn't correct: [" + driver.getTitle() + "]");
    }

    @Test
    void authorizationFromMenu() {
        new HomePageBpsSberbankPF(driver).openPage();
        new MainMenuItemStep(driver).clickOnMainMenuItem(driver, "Платежи и переводы");
        SberBankOnline sberBankOnline = new DropDownItemStep(driver).clickOnItem1DropDownMainMenu(driver, "Сбербанк Онлайн");
        sberBankOnline.getButtonEnterToBank().click();
//param test login-pass check if error string

        Assertions.assertTrue(driver.getTitle().equalsIgnoreCase("БПС-Сбербанк - Интернет банк - Возможности"), "Title isn't correct: [" + driver.getTitle() + "]");
    }

    @AfterAll
    static void browserClose() {

        driver.quit();
        driver = null;
    }
}
