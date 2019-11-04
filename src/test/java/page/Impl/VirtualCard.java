package page.Impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.AbstractPage;
import page.IPage;

public class VirtualCard extends AbstractPage<VirtualCard> implements IPage {

    private final static String initLocator="//div[@class='GameCardWrap__discounts--thirtyBorder']//a";

    @FindBy(xpath = initLocator)
    WebElement button;

    public WebElement getButton() {
        return button;
    }


    @Override
    public VirtualCard initPage() {
        new WebDriverWait(getDriverManager().getDriver(),WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(By.xpath(initLocator)));
        PageFactory.initElements(getDriverManager().getDriver(),this);
        return this;
    }
}
