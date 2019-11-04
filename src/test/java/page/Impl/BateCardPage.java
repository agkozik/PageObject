package page.Impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AbstractPage;
import page.IPage;

public class BateCardPage extends AbstractPage<BateCardPage> implements IPage {

    static final String initLocator ="t589__btn";


    @FindBy(className = initLocator )
    WebElement button;

    public WebElement getButton(){
        return  button;
    }

    @Override
    public BateCardPage initPage() {
        new WebDriverWait(getDriverManager().getDriver(), WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(By.className(initLocator)));
        PageFactory.initElements(getDriverManager().getDriver(), this);
        return this;
    }
}
