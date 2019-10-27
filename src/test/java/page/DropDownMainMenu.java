package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DropDownMainMenu extends AbstractPage {

    @FindBy(className = "nav__item_level-0")
    List<WebElement> headerDropDownMainMenu;

    @FindBy(className = "nav__item_level-1")
    List<WebElement> item1DropDownMainMenu;

    @FindBy(className = "nav__item_level-2")
    List<WebElement> item2DropDownMainMenu;

    public List<WebElement> getHeaderDropDownMainMenu() {
        return headerDropDownMainMenu;
    }

    public void setHeaderDropDownMainMenu(List<WebElement> headerDropDownMainMenu) {
        this.headerDropDownMainMenu = headerDropDownMainMenu;
    }

    public List<WebElement> getItem1DropDownMainMenu() {
        return item1DropDownMainMenu;
    }

    public void setItem1DropDownMainMenu(List<WebElement> item1DropDownMainMenu) {
        this.item1DropDownMainMenu = item1DropDownMainMenu;
    }

    public List<WebElement> getItem2DropDownMainMenu() {
        return item2DropDownMainMenu;
    }

    public void setItem2DropDownMainMenu(List<WebElement> item2DropDownMainMenu) {
        this.item2DropDownMainMenu = item2DropDownMainMenu;
    }

    public DropDownMainMenu(WebDriver driver) {
        super(driver);

    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }


}
