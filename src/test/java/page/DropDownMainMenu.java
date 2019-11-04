package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DropDownMainMenu extends AbstractPage<DropDownMainMenu> {

    @FindBy(className = "nav__item_level-0")
    List<WebElement> headerDropDownMainMenu;

    @FindBy(className = "nav__item_level-1")
    List<WebElement> item1DropDownMainMenu;

    @FindBy(className = "nav__item_level-2")
    List<WebElement> item2DropDownMainMenu;

    @FindBy(className = "nav")
    WebElement menu;

    public List<WebElement> getHeaderDropDownMainMenu() {
        return headerDropDownMainMenu;
    }

    public List<WebElement> getItem1DropDownMainMenu() {
        return item1DropDownMainMenu;
    }

    public List<WebElement> getItem2DropDownMainMenu() {
        return item2DropDownMainMenu;
    }

    public WebElement getMenu() {
        return menu;
    }

    @Override
    public DropDownMainMenu initPage() {

        new WebDriverWait(driverManager.getDriver(), WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(By.className("nav")));
        PageFactory.initElements(driverManager.getDriver(),this);
        return this;
    }


}
