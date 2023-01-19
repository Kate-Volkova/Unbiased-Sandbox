package unbiased_1.page;

import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    public void openMainPage() {
        Selenide.open("https://www.unbiased.co.uk/");
    }

    public void clickFinancialAdviserButton() {
        $x("//button[@onclick=\"goToMatchIntroPage('financial-adviser')\"]").click();
    }

}
