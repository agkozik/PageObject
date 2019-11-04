package step;

import page.Impl.KartaFunPage;

public class StepKartaFun implements IStep<KartaFunPage> {

    KartaFunPage kartaFunPage;

    public StepKartaFun() {
        kartaFunPage = new KartaFunPage().initPage();
    }

    @Override
    public KartaFunPage getPage() {
        return kartaFunPage;
    }


    public void clickOrderButton() {
        getPage().getButton().click();
    }
}
