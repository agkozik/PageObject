package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SberBankOnline extends AbstractPage {

    @FindBy(className = "btn-accent")
    WebElement buttonEnterToBank;

    public WebElement getButtonEnterToBank() {
        return buttonEnterToBank;
    }

    public SberBankOnline(WebDriver driver) {
        super(driver);
    }

    @Override
    protected AbstractPage openPage() {
        driver.get(" https://www.bps-sberbank.by/loginsbol");
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(By.id("app")));
        return this;
    }

}
