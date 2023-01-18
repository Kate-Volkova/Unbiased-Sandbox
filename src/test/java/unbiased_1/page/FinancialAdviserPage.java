package unbiased_1.page;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FinancialAdviserPage {

    public void clickBrowseAdviserDirectoryLink() {
        $(byText("Browse adviser directory")).click();
    }
}
