package unbiased_1;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import unbiased_1.page.AdvisersServiceFinancialAdviserPage;
import unbiased_1.page.FinancialAdviserPage;
import unbiased_1.page.MainPage;

import static com.codeborne.selenide.Selenide.$x;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindAdviserDirectorySearchTest extends BaseTest {

    @Test
    public void userCanFindAdviser() {

        MainPage mainPage = new MainPage();
        FinancialAdviserPage financialAdviserPage = new FinancialAdviserPage();
        AdvisersServiceFinancialAdviserPage advisersServiceFinancialAdviserPage = new AdvisersServiceFinancialAdviserPage();
        AdvisersServiceFinancialAdviserPage checkResults = new AdvisersServiceFinancialAdviserPage();

        mainPage.openMainPage();
        mainPage.clickFinancialAdviserButton();

        financialAdviserPage.clickBrowseAdviserDirectoryLink();

        advisersServiceFinancialAdviserPage.selectAdviseArea($x("//div[@id=\"list-item-160-1\"]"));
        advisersServiceFinancialAdviserPage.selectIncome($x("//div[@id=\"list-item-217-6\"]"));
        advisersServiceFinancialAdviserPage.setPostcodeValue("SE207AA");
        advisersServiceFinancialAdviserPage.submitRequest();

        checkResults.checkIfVisible();
        int result = checkResults.countResults();
        assertEquals(20, result);

        boolean isAdviserExist = checkResults.findParticularAdviserInSearchResults("The Private Office");
        Assertions.assertTrue(isAdviserExist);

    }
}
