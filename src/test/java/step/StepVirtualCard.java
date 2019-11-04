package step;

import org.openqa.selenium.interactions.Actions;
import page.Impl.VirtualCard;

public class StepVirtualCard implements IStep<VirtualCard>{
    VirtualCard virtualCard;

    public StepVirtualCard() {
        virtualCard=new VirtualCard().initPage();
    }


    @Override
    public VirtualCard getPage() {
        return virtualCard;
    }

    public void clickOrderButton(){
        Actions actions = new Actions(getPage().getDriverManager().getDriver());
        actions.moveToElement(getPage().getButton()).click().build().perform();
        //getPage().getButton().click();
    }
}
