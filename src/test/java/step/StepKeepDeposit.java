package step;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.KeepDeposit;

import java.util.List;

public class StepKeepDeposit {

    private KeepDeposit keepDeposit;

    public StepKeepDeposit(WebDriver driver) {
        keepDeposit = PageFactory.initElements(driver, KeepDeposit.class);
    }

    public void chooseMenu(WebDriver driver,String menu) {
        new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(By.className("SelectorDropDown__selector__selected-elem")));

        for (WebElement ind : keepDeposit.getDepositMenuItem()) {
            if (ind.getText().contains(menu)) {
                ind.click();
            }
        }
    }

    public void changeCurrency(WebDriver driver, String currencyCode) {

        new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(By.className("SelectorDropDown__selector__list")));
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

    public void useDepositCalculator(WebDriver driver, int profit, String sum) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", keepDeposit.getItemsCalc().get(0));

        Actions actions = new Actions(driver);

        for (int i = 90; i <= 1000; i++) {
            new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.className("SimpleCalculator__wrap--flex")));

            actions.doubleClick(keepDeposit.getItemsCalc().get(0)).sendKeys(String.valueOf(i)).build().perform();
            new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='SimpleCalculator__result--income']/span")));
            actions.doubleClick(keepDeposit.getItemsCalc().get(1)).sendKeys(sum).build().perform();

            WebElement currentProfit = driver.findElement(By.xpath("//div[@class='SimpleCalculator__result--income']/span"));
            Integer resultProfit = Integer.valueOf((currentProfit.getText()).substring(0, currentProfit.getText().indexOf(",")));

            if (resultProfit == profit) {
                System.out.println("Чтобы получить " + profit + " y.e нужно " + sum + " и " + i + " дней.");
                break;
            }
        }
    }

    public void useDepositCalculatorBinary(WebDriver driver, int profit, String sum, int lowBoundary, int highBoundary) {


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", keepDeposit.getItemsCalc().get(0));

        Actions actions = new Actions(driver);
        int currentValue = (highBoundary - lowBoundary) / 2;

        WebElement currentProfit;
        Integer resultProfit;
        int i = 0;

        while (lowBoundary <= highBoundary) {
            i++;
            System.out.println("Цикл FOR - итерация " + i);
            System.out.println("\t currentValue " + currentValue);
            new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.className("SimpleCalculator__wrap--flex")));

            actions.moveToElement(keepDeposit.getItemsCalc().get(0), 400, 0).doubleClick(keepDeposit.getItemsCalc().get(0)).sendKeys(String.valueOf(currentValue)).build().perform();

            new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='SimpleCalculator__result--income']/span")));
            actions.doubleClick(keepDeposit.getItemsCalc().get(1)).sendKeys(sum).build().perform();

            currentProfit = driver.findElement(By.xpath("//div[@class='SimpleCalculator__result--income']/span"));
            resultProfit = Integer.valueOf((currentProfit.getText()).substring(0, currentProfit.getText().indexOf(",")));

            if (resultProfit > profit) {
                highBoundary = currentValue;
                currentValue = (((highBoundary - lowBoundary) / 2) + lowBoundary);
                System.out.println("lowBoundary=" + lowBoundary + "\t currentValue= " + currentValue + "\t\t highBoundary= " + highBoundary + "\t\t resultProfit= " + resultProfit);
            }

            if (resultProfit < profit) {
                lowBoundary = currentValue;
                currentValue = (((highBoundary - lowBoundary) / 2) + lowBoundary);
                System.out.println("lowBoundary=" + lowBoundary + "\t currentValue= " + currentValue + "\t\t highBoundary= " + highBoundary + "\t\t resultProfit= " + resultProfit);
            }

            if (resultProfit == profit) {
                System.out.println("Чтобы получить " + profit + " y.e нужно " + sum + " и " + currentValue + " дней.");
                break;
            }
        }
    }
}
