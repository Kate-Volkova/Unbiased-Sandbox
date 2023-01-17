package unbiased_1.page;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AdvisersServiceFinancialAdviserPage {
    private final SelenideElement postcodeTextField = $x("//input[@id=\"filter-select-postcode\"]");
    private final SelenideElement submitButton = $x("//button[@id=\"filter-submit-button\"]");
    private final SelenideElement visibleElement = $(byText("Show only advisers available for contact"));
    private final ElementsCollection financialPlanningAdvisersResultsList = $$x("//h2");

    public void selectAdviseArea(SelenideElement adviseOnItemFinancialPlanning) {
        adviseOnItemFinancialPlanning.shouldBe(Condition.visible);
        adviseOnItemFinancialPlanning.click();
    }

    public void selectIncome(SelenideElement assertItem501000) {
        assertItem501000.shouldBe(Condition.visible);
        assertItem501000.click();
    }

    public void setPostcodeValue(String postcodeValue) { postcodeTextField.val(postcodeValue); }

    public void submitRequest() { submitButton.click(); }

    public void checkIfVisible () {visibleElement.shouldBe(Condition.visible);}

    public int countResults() {
        return financialPlanningAdvisersResultsList.size();
    }

    public boolean findParticularAdviserInSearchResults(String adviserName) {
        boolean trueFalse = false;
        for (SelenideElement adviser : financialPlanningAdvisersResultsList) {
            String name = adviser.getText();
            if (name.equalsIgnoreCase(adviserName)) {
                trueFalse = true;
                break;
            }
        }
        return trueFalse;
    }
}
