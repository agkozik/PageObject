package step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.HomePageBpsSberbankPF;

public class MainMenuItemStep {

    private HomePageBpsSberbankPF homePageBpsSberbankPF;

    public MainMenuItemStep(WebDriver driver) {
        homePageBpsSberbankPF = PageFactory.initElements(driver, HomePageBpsSberbankPF.class);
    }

    public void clickOnMainMenuItem(WebDriver driver, String name) {

        for (WebElement element : homePageBpsSberbankPF.getMainMenuItems()) {
            if (element.getText().equalsIgnoreCase(name)) {
                element.click();
                new WebDriverWait(driver,5).until(ExpectedConditions.titleIs("БПС-Сбербанк - Выбрать карту"));
                return;
            }
        }
        throw new RuntimeException("Element with name " + name + " not found");
    }
}
