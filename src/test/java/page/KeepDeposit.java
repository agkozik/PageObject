package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class KeepDeposit extends AbstractPage {

    @FindBy(xpath = "//li[@class='depo_elem']")
    List<WebElement> depositMenuItem;

    @FindBy(className = "InputSlider__wrap")
    List<WebElement> itemsCalc;

    public KeepDeposit(WebDriver driver) {
        super(driver);
    }

    @Override
    protected AbstractPage openPage() {
        driver.get("https://www.bps-sberbank.by/deposit/save-online-unrecall-foreign/EUR/attributes");
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(By.id("app")));
        return this;
    }

    public void chooseMenu(String menu) {
        for (WebElement ind : depositMenuItem) {
            if (ind.getText().contains(menu)) {
                ind.click();
            }
        }
    }

    public void changeCurrency(String currencyCode) {

        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.className("SelectorDropDown__selector__list_elem_icon")));
        List<WebElement> menuCurrency = driver.findElements(By.className("SelectorDropDown__selector__list_elem_icon"));

        System.out.println("Quantity of Валюта " + menuCurrency.size() + menuCurrency.get(2).getText());

        switch (currencyCode) {
            case "EUR":
                menuCurrency.get(0).click();
                break;
            case "USD":
                menuCurrency.get(1).click();
                break;
            case "RUB":
                menuCurrency.get(2).click();
                break;
            default:
                System.out.println("Currency not found");
        }
    }

    public void useDepositCalculator(int profit, String sum) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", itemsCalc.get(0));

        Actions actions = new Actions(driver);

        for (int i = 90; i <= 1000; i++) {
            new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.className("SimpleCalculator__wrap--flex")));

            actions.doubleClick(itemsCalc.get(0)).sendKeys(String.valueOf(i)).build().perform();
            new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='SimpleCalculator__result--income']/span")));
            actions.doubleClick(itemsCalc.get(1)).sendKeys(sum).build().perform();

            WebElement currentProfit = driver.findElement(By.xpath("//div[@class='SimpleCalculator__result--income']/span"));
            Integer resultProfit = Integer.valueOf((currentProfit.getText()).substring(0, currentProfit.getText().indexOf(",")));

            if (resultProfit == profit) {
                System.out.println("Чтобы получить " + profit + " y.e нужно " + sum + " и " + i + " дней.");
                break;
            }
        }
    }

    public void useDepositCalculatorBinary(int profit, String sum, int lowBoundary, int highBoundary) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", itemsCalc.get(0));

        Actions actions = new Actions(driver);
        int currentValue = (highBoundary - lowBoundary) / 2;

        WebElement currentProfit;
        Integer resultProfit;
        int i = 0;

        while (lowBoundary<=highBoundary) {
            i++;
            System.out.println("Цикл FOR - итерация " + i );
            System.out.println("\t currentValue " + currentValue);
            new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.className("SimpleCalculator__wrap--flex")));

            actions.moveToElement(itemsCalc.get(0), 400, 0).doubleClick(itemsCalc.get(0)).sendKeys(String.valueOf(currentValue)).build().perform();

            new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='SimpleCalculator__result--income']/span")));
            actions.doubleClick(itemsCalc.get(1)).sendKeys(sum).build().perform();

            currentProfit = driver.findElement(By.xpath("//div[@class='SimpleCalculator__result--income']/span"));
            resultProfit = Integer.valueOf((currentProfit.getText()).substring(0, currentProfit.getText().indexOf(",")));

            if (resultProfit > profit) {
                highBoundary = currentValue;
                currentValue = (((highBoundary - lowBoundary) / 2) + lowBoundary);
                System.out.println("lowBoundary="+lowBoundary+"\t currentValue= " + currentValue + "\t\t highBoundary= "  + highBoundary + "\t\t resultProfit= "+ resultProfit);
            }

            if (resultProfit < profit) {
                lowBoundary = currentValue;
                currentValue = (((highBoundary - lowBoundary) / 2) + lowBoundary);
                System.out.println("lowBoundary="+lowBoundary+"\t currentValue= " + currentValue + "\t\t highBoundary= "  + highBoundary + "\t\t resultProfit= "+ resultProfit);
            }

            if (resultProfit == profit) {
                System.out.println("Чтобы получить " + profit + " y.e нужно " + sum + " и " + currentValue + " дней.");
                break;
            }
        }
    }

}
