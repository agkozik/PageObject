package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ForeignCurrencyDeposit extends AbstractPage {

    @FindBy(className = "DepositesSelectionResult")
    List<WebElement> selectDeposit;

    @FindBy(className = "DepositesSelectionResult__buttons")
    List<WebElement> buttonMore;

    public ForeignCurrencyDeposit(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getSelectDeposit() {
        return selectDeposit;
    }

    public List<WebElement> getButtonMore() {
        return buttonMore;
    }

    @Override
    protected AbstractPage openPage() {
        driver.get("https://www.bps-sberbank.by/page/deposit-foreign-currency");
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(By.id("app")));
        return this;
    }
}
