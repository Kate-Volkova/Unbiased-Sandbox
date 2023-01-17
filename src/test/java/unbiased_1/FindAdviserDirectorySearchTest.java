package unbiased_1;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import unbiased_1.page.AdvisersServiceFinancialAdviserPage;
import unbiased_1.page.FinancialAdviserPage;
import unbiased_1.page.MainPage;

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

        advisersServiceFinancialAdviserPage.selectAdviseArea();
        advisersServiceFinancialAdviserPage.selectIncome();
        advisersServiceFinancialAdviserPage.setPostcodeValue();
        advisersServiceFinancialAdviserPage.submitRequest();

        checkResults.checkIfVisible();
        int result = checkResults.countResults();
        assertEquals(20, result);

        boolean trueFalse = checkResults.findParticularAdviserInSearchResults();
        Assertions.assertTrue(trueFalse);

    }
}
