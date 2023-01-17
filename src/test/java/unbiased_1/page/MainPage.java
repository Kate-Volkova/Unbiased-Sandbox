package unbiased_1.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement financialAdviserButton = $x("//button[@onclick=\"goToMatchIntroPage('financial-adviser')\"]");

    public void openMainPage() {
        Selenide.open("https://www.unbiased.co.uk/");
    }

    public void clickFinancialAdviserButton() {
        financialAdviserButton.click();
    }

}
