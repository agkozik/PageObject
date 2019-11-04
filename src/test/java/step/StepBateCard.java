package step;

import page.Impl.BateCardPage;

import java.util.ArrayList;

public class StepBateCard implements IStep<BateCardPage> {

    BateCardPage bateCardPage;

    public StepBateCard() {
        bateCardPage = new BateCardPage().initPage();
    }

    @Override
    public BateCardPage getPage() {
        return bateCardPage;
    }


    public void clickOrderButton() {

        String currentWindowHandle = bateCardPage.getDriverManager().getDriver().getWindowHandle();

        getPage().getButton().click();

                bateCardPage.getDriverManager().getDriver().switchTo().window(currentWindowHandle);

        }
    }

//    String currentWindowHandle = bateCardPage.getDriverManager().getDriver().getWindowHandle();
//
//    getPage().getButton().click();
//        ArrayList<String> windowHandles = new ArrayList<>(bateCardPage.getDriverManager().getDriver().getWindowHandles());
//        for (String window : windowHandles) {
//
//        //if it contains the current window we want to eliminate that from switchTo();
//        if (window != currentWindowHandle) {
//        //Now switchTo new Tab.
//        bateCardPage.getDriverManager().getDriver().switchTo().window(currentWindowHandle);
//        //Do whatever you want to do here.
//
//        //Close the newly opened tab
//        // bateCardPage.getDriverManager().getDriver().close();
//        }
//        }