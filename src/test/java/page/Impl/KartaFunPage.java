package page.Impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AbstractPage;
import page.IPage;

public class KartaFunPage extends AbstractPage<KartaFunPage> implements IPage {

    static final String initLocator ="nav__button-order";

    @FindBy(className = initLocator)
    WebElement button;

    @Override
    public KartaFunPage initPage() {
        new WebDriverWait(getDriverManager().getDriver(), WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(By.className(initLocator)));
        PageFactory.initElements(getDriverManager().getDriver(), this);
        return this;
    }

    public WebElement getButton(){
        return  button;
    }
}
