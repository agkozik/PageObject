package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class KeepDeposit extends AbstractPage {

    @FindBy(xpath = "//li[@class='depo_elem']")
    List<WebElement> depositMenuItem;

    @FindBy(className = "InputSlider__wrap")
    List<WebElement> itemsCalc;

    public List<WebElement> getDepositMenuItem() {
        return depositMenuItem;
    }

    public List<WebElement> getItemsCalc() {
        return itemsCalc;
    }

    @Override
    public AbstractPage initPage() {
        driverManager.getDriver().get("https://www.bps-sberbank.by/deposit/save-online-unrecall-foreign/EUR/attributes");
        new WebDriverWait(driverManager.getDriver(), WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("app")));
        return this;
    }

}
