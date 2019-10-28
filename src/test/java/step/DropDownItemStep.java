package step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.DropDownMainMenu;

import java.util.List;

public class DropDownItemStep {

    DropDownMainMenu dropDownMainMenu;

    public DropDownItemStep(WebDriver driver) {
        dropDownMainMenu = PageFactory.initElements(driver, DropDownMainMenu.class);
    }

    public DropDownMainMenu getDropDownMainMenu() {
        return dropDownMainMenu;
    }

    public void setDropDownMainMenu(DropDownMainMenu dropDownMainMenu) {
        this.dropDownMainMenu = dropDownMainMenu;
    }

    public void clickOnDropDownMainMenu(WebDriver driver, String searchItem, List<WebElement> item) {

        for (WebElement el : item) {
            if (el.getText().equalsIgnoreCase(searchItem)) {
                el.click();
                new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.id("app")));
                return;
            }
        }
        throw new RuntimeException("Element with name " + searchItem + " not found");
    }

//
//    public SberBankOnline clickOnHeaderDropDownMainMenu(WebDriver driver, String header) {
//        for (WebElement el : dropDownMainMenu.getHeaderDropDownMainMenu()) {
//            if (el.getText().equalsIgnoreCase(header)) {
//                el.click();
//                new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.id("app")));
//                return new SberBankOnline(driver);
//            }
//        }
//        throw new RuntimeException("Element with name " + header + " not found");
//    }
//


}
