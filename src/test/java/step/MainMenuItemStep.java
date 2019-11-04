package step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.HomePageBpsSberbankPF;

public class MainMenuItemStep {

    private HomePageBpsSberbankPF homePageBpsSberbankPF;

    public MainMenuItemStep() {
        homePageBpsSberbankPF = new HomePageBpsSberbankPF().initPage();

    }

    public DropDownItemStep clickOnMainMenuItem(String name) {

        for (WebElement element : homePageBpsSberbankPF.getMainMenuItems()) {
            if (element.getText().equalsIgnoreCase(name)) {
                element.click();
                new WebDriverWait(homePageBpsSberbankPF.getDriverManager().getDriver(), 15)
                        .until(ExpectedConditions.elementToBeClickable(By.className("nav__item_level-0")));
                return new DropDownItemStep();
            }
        }
        throw new RuntimeException("Element with name " + name + " not found");
    }
}
