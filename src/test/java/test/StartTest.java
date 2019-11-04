package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.*;
import step.*;

import java.awt.*;

class StartTest {

    private static WebDriverManager webDriverManager = WebDriverManager.getInstance();

    @BeforeAll
    public static void moveCursorOut() throws AWTException {
        Robot bot = new Robot();
        bot.mouseMove(0, 0);
    }

    @Test
    void FirstTest() {

        DropDownItemStep dropDownItemStep = new MainMenuItemStep().clickOnMainMenuItem("Карты");
        Assertions.assertTrue(dropDownItemStep.isOpen());
    }

    @ParameterizedTest
    @CsvSource({
            "Карты, Премиальные карты, Кобрендинговая карта с ФК БАТЭ",
            "Карты, Премиальные карты, Visa Rewards PayWave КартаFUN",
            "Карты, Пенсионные карты, Visa Classic Пенсионная",
            "Карты, Карты с Money-Back, Mastercard World ComPass в иностранной валюте",
            "Карты, Бонусные карты, Mastercard Virtual GameCard",
            "Карты, Виртуальные карты, Visa Virtuon"})
    void authorizationFromMenu(String mainMenuItem, String cardGroup, String cardName) {

        new MainMenuItemStep()
                .clickOnMainMenuItem(mainMenuItem)
                .openCardGroup(cardGroup)
                .chooseCardAndClickMoreButton(cardName)
                .clickOrderButton();
        System.out.println(webDriverManager.getDriver().getTitle());

    }



//
//    @ParameterizedTest
//    @CsvSource({"Карты, Пенсионные карты"})
//            //, "Депозиты", "Кредиты", "Платежи и переводы", "Страхование и другие услуги", "Ещё"})
//    void clickOnAllMenuItems(String mainMenuItemName, String dropMenuItem) {
//        new MainMenuItemStep()
//                .clickOnMainMenuItem(mainMenuItemName)
//                .openPremiumCard(dropMenuItem)
//
//        new HomePageBpsSberbankPF().initPage();
//        new MainMenuItemStep().clickOnMainMenuItem(driver, mainMenuItemName);
//        Assertions.assertNotEquals("БПС-Сбербанк - Главная", driver.getTitle());
//
//    }
//
//    @ParameterizedTest
//    @CsvFileSource(resources = "/csv_data.csv", numLinesToSkip = 1)
//    void testDropDownMenuHeaderWithCsvFileSource(String menu, String header, String item1, String item2) {
//        new HomePageBpsSberbankPF().initPage();
//        DropDownMainMenu dropDownMainMenu = new MainMenuItemStep().clickOnMainMenuItem(driver, menu);
//        new DropDownItemStep(driver).clickOnDropDownMainMenu(driver, header, dropDownMainMenu.getHeaderDropDownMainMenu());
//        Assertions.assertNotEquals("БПС-Сбербанк - Главная", driver.getTitle());
//
//    }
//
//    @ParameterizedTest
//    @CsvFileSource(resources = "/csv_data.csv", numLinesToSkip = 1)
//    void testDropDownMenuItem1WithCsvFileSource(String menu, String header, String item1, String item2) {
//        new HomePageBpsSberbankPF().initPage();
//        DropDownMainMenu dropDownMainMenu = new MainMenuItemStep().clickOnMainMenuItem(driver, menu);
//        new DropDownItemStep(driver).clickOnDropDownMainMenu(driver, item1, dropDownMainMenu.getItem1DropDownMainMenu());
//        Assertions.assertNotEquals("БПС-Сбербанк - Главная", driver.getTitle());
//
//    }
//
//    @ParameterizedTest
//    @CsvFileSource(resources = "/csv_data.csv", numLinesToSkip = 1)
//    void testDropDownMenuItem2WithCsvFileSource(String menu, String header, String item1, String item2) {
//        new HomePageBpsSberbankPF().initPage();
//        DropDownMainMenu dropDownMainMenu = new MainMenuItemStep().clickOnMainMenuItem(driver, menu);
//        new DropDownItemStep(driver).clickOnDropDownMainMenu(driver, item2, dropDownMainMenu.getItem2DropDownMainMenu());
//        Assertions.assertNotEquals("БПС-Сбербанк - Главная", driver.getTitle());
//
//    }
//
//    @ParameterizedTest
//    @CsvSource({"10, 10000"})
//    void findHowToEarn100USDIfYouHave10000USD(int profit, String sum) {
//        new HomePageBpsSberbankPF().initPage();
//        DropDownMainMenu dropDownMainMenu = new MainMenuItemStep().clickOnMainMenuItem(driver, "Депозиты");
//        new DropDownItemStep(driver).clickOnDropDownMainMenu(driver, "В ИНОСТРАННОЙ ВАЛЮТЕ", dropDownMainMenu.getHeaderDropDownMainMenu());
//        new StepForeignCurrencyDeposit(driver).clickButtonMore(1);
//
//        new StepKeepDeposit(driver).chooseMenu(driver,"ВАЛЮТА");
//        new StepKeepDeposit(driver).changeCurrency(driver,"USD");
//        new StepKeepDeposit(driver).useDepositCalculator(driver,profit,sum);
//        new StepKeepDeposit(driver).useDepositCalculatorBinary(driver,profit,sum,90,1000);
//
//        System.out.println(driver.getTitle());
//    }


    @AfterAll
    static void browserClose() {
        webDriverManager.getDriver().quit();
        webDriverManager = null;
    }
}
