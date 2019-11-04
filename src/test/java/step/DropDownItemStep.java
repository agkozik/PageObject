package step;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.DropDownMainMenu;

import java.util.List;

public class DropDownItemStep {

    DropDownMainMenu dropDownMainMenu;

    public DropDownItemStep() {
        dropDownMainMenu = new DropDownMainMenu().initPage();
    }

    public DropDownMainMenu getDropDownMainMenu() {
        return dropDownMainMenu;
    }

   public CardStep openCardGroup(String name)
   {
       clickOnDropDownMainMenu(name,dropDownMainMenu.getItem1DropDownMainMenu());
       return new CardStep();
   }

   public CardStep openCard(String cardName){
        clickOnDropDownMainMenu(cardName,dropDownMainMenu.getItem2DropDownMainMenu());
        return new CardStep();
   }

   public CardStep openMenuHeader(String header){
        clickOnDropDownMainMenu(header,dropDownMainMenu.getHeaderDropDownMainMenu());
        return new CardStep();
   }


    private void clickOnDropDownMainMenu( String searchItem, List<WebElement> item) {

        for (WebElement el : item) {
            if (el.getText().equalsIgnoreCase(searchItem)) {
                el.click();
                new WebDriverWait(dropDownMainMenu.getDriverManager().getDriver(), 5).until(ExpectedConditions.elementToBeClickable(By.id("app")));
                return;
            }
        }
        throw new RuntimeException("Element with name " + searchItem + " not found");
    }
    public boolean isOpen()
    {
        return dropDownMainMenu.getMenu().isDisplayed();
    }

}
