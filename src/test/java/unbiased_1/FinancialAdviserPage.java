// Financial Adviser Search start page

package unbiased_1;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class FinancialAdviserPage {
    private final SelenideElement browseLink = $("#app > div > main > div > div > div > div.row.no-gutters.mb-6.justify-center > div > a");

    public void clickBrowseLink() {
        browseLink.click();
    }

}
