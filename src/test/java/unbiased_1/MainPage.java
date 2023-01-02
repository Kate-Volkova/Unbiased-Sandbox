// Open the main Unbiased page

package unbiased_1;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final SelenideElement buttonFinancialAdviser = $("#home-page-body > div.b-hero.b-hero-main > div > div.b-hero__content > div > div > div > div.card.pa-xs-16 > div.row > div:nth-child(1) > button");

    public void clickFinancialAdviser() {
        buttonFinancialAdviser.click();
    }

    public void openPage (String url) {
        Selenide.open(url);
    }

}
