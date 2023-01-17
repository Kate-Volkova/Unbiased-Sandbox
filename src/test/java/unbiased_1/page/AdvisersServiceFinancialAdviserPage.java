package unbiased_1.page;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AdvisersServiceFinancialAdviserPage {
    private final SelenideElement adviseOnItemFinancialPlanning = $x("//div[@id=\"list-item-160-1\"]");
    private final SelenideElement assertItem501000 = $x("//div[@id=\"list-item-217-6\"]");
    private final SelenideElement postcodeTextField = $x("//input[@id=\"filter-select-postcode\"]");
    private final static String POSTCODE_VALUE = "SE207AA";
    private final SelenideElement submitButton = $x("//button[@id=\"filter-submit-button\"]");
    private final SelenideElement visibleElement = $(byText("Show only advisers available for contact"));
    private final ElementsCollection financialPlanningAdvisersResultsList = $$x("//h2");
    private final static String ADVISER_NAME = "The Private Office";


    public void selectAdviseArea() {
        adviseOnItemFinancialPlanning.shouldBe(Condition.visible);
        adviseOnItemFinancialPlanning.click();
    }

    public void selectIncome() {
        assertItem501000.shouldBe(Condition.visible);
        assertItem501000.click();
    }

    public void setPostcodeValue() { postcodeTextField.val(POSTCODE_VALUE); }

    public void submitRequest() { submitButton.click(); }

    public void checkIfVisible () {visibleElement.shouldBe(Condition.visible);}

    public int countResults() {
        return financialPlanningAdvisersResultsList.size();
    }

    public boolean findParticularAdviserInSearchResults() {
        boolean trueFalse = false;
        for (SelenideElement adviser : financialPlanningAdvisersResultsList) {
            String name = adviser.getText();
            if (name.equalsIgnoreCase(ADVISER_NAME)) {
                trueFalse = true;
                break;
            }
        }
        return trueFalse;
    }
}
