package step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.DropDownMainMenu;
import page.SberBankOnline;

public class DropDownItemStep {

    DropDownMainMenu dropDownMainMenu;

    public DropDownItemStep(WebDriver driver) {
        dropDownMainMenu = PageFactory.initElements(driver, DropDownMainMenu.class);
    }


    public SberBankOnline clickOnHeaderDropDownMainMenu(WebDriver driver, String header) {
        for (WebElement el : dropDownMainMenu.getHeaderDropDownMainMenu()) {
            if (el.getText().equalsIgnoreCase(header)) {
                el.click();
                new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.id("app")));
                return new SberBankOnline(driver);
            }
        }
        throw new RuntimeException("Element with name " + header + " not found");
    }


    public SberBankOnline clickOnItem1DropDownMainMenu(WebDriver driver, String item1) {
        for (WebElement el : dropDownMainMenu.getItem1DropDownMainMenu()) {
            if (el.getText().equalsIgnoreCase(item1)) {
                el.click();
                new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.id("app")));
                return new SberBankOnline(driver);
            }
        }
        throw new RuntimeException("Element with name " + item1 + " not found");
    }


    public SberBankOnline clickOnItem2DropDownMainMenu(WebDriver driver, String item2) {
        for (WebElement el : dropDownMainMenu.getItem2DropDownMainMenu()) {
            if (el.getText().equalsIgnoreCase(item2)) {
                el.click();
                new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.id("app")));
                return new SberBankOnline(driver);
            }
        }
        throw new RuntimeException("Element with name [" + item2 + "] not found");
    }

}
