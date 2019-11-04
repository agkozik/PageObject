package step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.ForeignCurrencyDeposit;

public class StepForeignCurrencyDeposit {

    private ForeignCurrencyDeposit foreignCurrencyDeposit;

    public StepForeignCurrencyDeposit(WebDriver driver) {
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.className("DepositesSelectionResult")));
        foreignCurrencyDeposit = PageFactory.initElements(driver,ForeignCurrencyDeposit.class);
    }

    public void clickButtonMore(int index) {
       foreignCurrencyDeposit.getButtonMore().get(index).click();
       return;
    }



}
