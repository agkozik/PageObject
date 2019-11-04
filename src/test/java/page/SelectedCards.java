package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SelectedCards extends AbstractPage<SelectedCards>{

    @FindBy(className = "ProductTile")
    List<WebElement> listOfCards;

    @FindBy(xpath = "//div[@class='ProductTileInner__Header']/h2")
    List<WebElement> headersListOfCards;

    @FindBy(className = "btn-default")
    List<WebElement> buttonMore;

    @FindBy(className = "btn-primary")
    List<WebElement> buttonOrder;


    public List<WebElement> getHeadersListOfCards() {
        return headersListOfCards;
    }

    public List<WebElement> getListOfCards() {
        return listOfCards;
    }

    public List<WebElement> getButtonMore() {
        return buttonMore;
    }

    public List<WebElement> getButtonOrder() {
        return buttonOrder;
    }

    @Override
    public SelectedCards initPage() {

        new WebDriverWait(driverManager.getDriver(), WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.className("BlockListOfCards")));
        PageFactory.initElements(driverManager.getDriver(),this);
        return this;
    }
}
