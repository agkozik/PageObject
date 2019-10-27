package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        return null;
    }

}
