package step;

import page.IPage;
import page.Impl.OtherCards;

public class StepOtherCards implements IStep<OtherCards> {
   OtherCards otherCards;

    public StepOtherCards() {
        otherCards=new OtherCards().initPage();
    }

    @Override
    public OtherCards getPage() {
        return otherCards;
    }


    public void clickOrderButton(){
        getPage().getButton().click();
    }
}
