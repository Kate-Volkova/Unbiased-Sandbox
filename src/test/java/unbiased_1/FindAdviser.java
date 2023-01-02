package unbiased_1;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindAdviser extends BaseTest {
    private final static String baseURL = "https://www.unbiased.co.uk/";
    private final ElementsCollection itemsCollection = $$x("//div[@tabindex=0]");
    private final static String adviseItem = "Financial planning";
    private final static String assetItem = "£501,000+";
    private final SelenideElement postcode = $x("//input[@id=\"filter-select-postcode\"]");
    private final static String postcodeValue = "SE207AA";
    private final SelenideElement submitButton = $x("//button[@id=\"filter-submit-button\"]");
    private final SelenideElement visibleElement = $("#directory-search-results > div.container.py-0.px-sm-5.px-lg-8.px-xl-12.container--fluid > div.text-center.py-3.show-all-advisors-filter > div > div > div > label");
    private final ElementsCollection resultsList = $$x("//h2");
    private final String adviserName = "The Private Office";


    @Test
    public void userCanFindAdviser() {
        MainPage mainPage = new MainPage();
        mainPage.openPage(baseURL);
        mainPage.clickFinancialAdviser();

        FinancialAdviserPage financialAdviserPage = new FinancialAdviserPage();
        financialAdviserPage.clickBrowseLink();

        DirectorySearch directorySearch = new DirectorySearch();
        directorySearch.clickItem(itemsCollection, adviseItem);
        directorySearch.clickItem(itemsCollection, assetItem);
        directorySearch.setPostcodeValue(postcode, postcodeValue);
        directorySearch.submitRequest(submitButton);

        DirectorySearch checkResults = new DirectorySearch();
        int result = checkResults.countResults(resultsList, visibleElement);
        assertEquals(20, result);

        boolean trueFalse = checkResults.findAdviser(resultsList, adviserName);
        Assertions.assertTrue(trueFalse);

    }
}
