package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePageBpsSberbankPF extends AbstractPage<HomePageBpsSberbankPF> {

    private static final String HOMEPAGE_URL = "https://www.bps-sberbank.by/";

    @FindBy(className = "main-menu__nav-item-inner")
    private List<WebElement> mainMenuItems;

    public List<WebElement> getMainMenuItems() {
        return mainMenuItems;
    }

    public HomePageBpsSberbankPF initPage() {

        driverManager.getDriver().get(HOMEPAGE_URL);
        new WebDriverWait(driverManager.getDriver(), WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(By.className("main-menu")));
        PageFactory.initElements(driverManager.getDriver(),this);
        return this;
    }

}
