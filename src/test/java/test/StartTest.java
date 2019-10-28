package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.DropDownMainMenu;
import page.HomePageBpsSberbankPF;
import page.KeepDeposit;
import page.SberBankOnline;
import step.DropDownItemStep;
import step.MainMenuItemStep;
import step.StepForeignCurrencyDeposit;

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
        Assertions.assertEquals("БПС-Сбербанк - Выбрать карту", driver.getTitle());
    }

    @Test
    void authorizationFromMenu() {
        new HomePageBpsSberbankPF(driver).openPage();
        DropDownMainMenu dropDownMainMenu = new MainMenuItemStep(driver).clickOnMainMenuItem(driver, "Платежи и переводы");
        new DropDownItemStep(driver)
                .clickOnDropDownMainMenu(driver, "Сбербанк Онлайн", dropDownMainMenu.getItem1DropDownMainMenu());
        new SberBankOnline(driver).getButtonEnterToBank().click();
        Assertions.assertEquals("БПС-Сбербанк - Интернет банк - Возможности", driver.getTitle());

    }

    @ParameterizedTest
    @CsvSource({"Карты", "Депозиты", "Кредиты", "Платежи и переводы", "Страхование и другие услуги", "Ещё"})
    void clickOnAllMenuItems(String mainMenuItemName) {
        new HomePageBpsSberbankPF(driver).openPage();
        new MainMenuItemStep(driver).clickOnMainMenuItem(driver, mainMenuItemName);
        Assertions.assertNotEquals("БПС-Сбербанк - Главная", driver.getTitle());

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv_data.csv", numLinesToSkip = 1)
    void testDropDownMenuHeaderWithCsvFileSource(String menu, String header, String item1, String item2) {
        new HomePageBpsSberbankPF(driver).openPage();
        DropDownMainMenu dropDownMainMenu = new MainMenuItemStep(driver).clickOnMainMenuItem(driver, menu);
        new DropDownItemStep(driver).clickOnDropDownMainMenu(driver, header, dropDownMainMenu.getHeaderDropDownMainMenu());
        Assertions.assertNotEquals("БПС-Сбербанк - Главная", driver.getTitle());

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv_data.csv", numLinesToSkip = 1)
    void testDropDownMenuItem1WithCsvFileSource(String menu, String header, String item1, String item2) {
        new HomePageBpsSberbankPF(driver).openPage();
        DropDownMainMenu dropDownMainMenu = new MainMenuItemStep(driver).clickOnMainMenuItem(driver, menu);
        new DropDownItemStep(driver).clickOnDropDownMainMenu(driver, item1, dropDownMainMenu.getItem1DropDownMainMenu());
        Assertions.assertNotEquals("БПС-Сбербанк - Главная", driver.getTitle());

    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv_data.csv", numLinesToSkip = 1)
    void testDropDownMenuItem2WithCsvFileSource(String menu, String header, String item1, String item2) {
        new HomePageBpsSberbankPF(driver).openPage();
        DropDownMainMenu dropDownMainMenu = new MainMenuItemStep(driver).clickOnMainMenuItem(driver, menu);
        new DropDownItemStep(driver).clickOnDropDownMainMenu(driver, item2, dropDownMainMenu.getItem2DropDownMainMenu());
        Assertions.assertNotEquals("БПС-Сбербанк - Главная", driver.getTitle());

    }

    @ParameterizedTest
    @CsvSource({"100, 10000"})
    void findHowToEarn100USDIfYouHave10000USD(int profit, String sum) {
        new HomePageBpsSberbankPF(driver).openPage();
        DropDownMainMenu dropDownMainMenu = new MainMenuItemStep(driver).clickOnMainMenuItem(driver, "Депозиты");
        new DropDownItemStep(driver).clickOnDropDownMainMenu(driver, "В ИНОСТРАННОЙ ВАЛЮТЕ", dropDownMainMenu.getHeaderDropDownMainMenu());
        new StepForeignCurrencyDeposit(driver).clickButtonMore(1);

        KeepDeposit keepDeposit = new KeepDeposit(driver);
        keepDeposit.chooseMenu("ВАЛЮТА");
        keepDeposit.changeCurrency("USD");
        keepDeposit.useDepositCalculator(10, "10000");
        keepDeposit.useDepositCalculatorBinary(10, "10000", 90, 1000);

        System.out.println(driver.getTitle());
    }


    @AfterAll
    static void browserClose() {
        driver.quit();
        driver = null;
    }
}
