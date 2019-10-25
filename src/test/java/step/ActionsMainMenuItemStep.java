package step;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import page.BpsSberbankHomePagePF;

public class ActionsMainMenuItemStep {

    BpsSberbankHomePagePF bpsSberbankHomePagePF;

    public ActionsMainMenuItemStep(WebDriver driver) {
        bpsSberbankHomePagePF = PageFactory.initElements(driver, BpsSberbankHomePagePF.class);
    }

    public void clickOnMainMenuItem(WebDriver driver, String name) {

        for (WebElement element : bpsSberbankHomePagePF.getMainMenuItems()) {
            if (element.getText().equalsIgnoreCase(name)) {
                element.click();
                return;
            }
        }
        throw new RuntimeException("Element with name " + name + " not found");
    }
}
