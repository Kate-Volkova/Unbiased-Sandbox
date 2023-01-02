package unbiased_1.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FinancialAdviserPage {
    private final SelenideElement browseAdviserDirectoryLink = $(byText("Browse adviser directory"));

    public void clickBrowseAdviserDirectoryLink() {
        browseAdviserDirectoryLink.click();
    }
}
