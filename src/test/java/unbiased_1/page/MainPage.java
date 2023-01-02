package unbiased_1.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement FinancialAdviserButton = $x("//button[@onclick=\"goToMatchIntroPage('financial-adviser')\"]");
    private final static String BASE_URL = "https://www.unbiased.co.uk/";

    public void openMainPage() {
        Selenide.open(BASE_URL);
    }

    public void clickFinancialAdviserButton() {
        FinancialAdviserButton.click();
    }

}
