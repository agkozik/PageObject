package step;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.Impl.OtherCards;
import page.SelectedCards;

public class CardStep {

    SelectedCards selectedCards;

    public CardStep() {

        selectedCards = new SelectedCards().initPage();
    }

    public SelectedCards getSelectedCards() {
        return selectedCards;
    }

    public <E extends IStep> E chooseCardAndClickMoreButton(String name) {

        for (WebElement el : selectedCards.getListOfCards()) {
            if (el.findElement(By.className("ProductTileInner__Title")).getText().equalsIgnoreCase(name)) {

                JavascriptExecutor js = (JavascriptExecutor) selectedCards.getDriverManager().getDriver();
                js.executeScript("arguments[0].scrollIntoView();", el);

                Actions actions = new Actions(selectedCards.getDriverManager().getDriver());
                actions.moveToElement(el).build().perform();

                new WebDriverWait(selectedCards.getDriverManager().getDriver(), 20)
                        .until(ExpectedConditions.presenceOfElementLocated(By.className("btn-default")));
                el.findElement(By.className("btn-default")).click();

                new WebDriverWait(selectedCards.getDriverManager().getDriver(), 15)
                        .until(ExpectedConditions.not(ExpectedConditions.titleIs("БПС-Сбербанк - Выбрать карту")));

                switch (name) {

                    case "Visa Rewards PayWave КартаFUN": {
                        return (E) new StepKartaFun();
                    }
                    case "Кобрендинговая карта с ФК БАТЭ": {
                        return (E) new StepBateCard();
                    }
                    case "Mastercard Virtual GameCard": {
                        return (E) new StepVirtualCard();
                    }

                    default: {
                        return (E) new StepOtherCards();
                    }
                }
            }
        }
        throw new RuntimeException("Card " + name + " Not exist");
    }

}
