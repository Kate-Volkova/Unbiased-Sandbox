package unbiased_1.page;

import com.codeborne.selenide.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AdvisersServiceFinancialAdviserPage {
    private final ElementsCollection financialPlanningAdvisersResultsList = $$x("//h2");

    public void selectDropDownMenuItem(String dropDownMenu, String itemName) {
        $(byId(dropDownMenu)).shouldBe(Condition.visible).find(byText(itemName)).click();
    }

    public void setPostcodeValue(String postcodeValue) {
        $x("//input[@id=\"filter-select-postcode\"]").val(postcodeValue);
    }

    public void submitRequest() { $x("//button[@id=\"filter-submit-button\"]").click(); }

    public void checkIfVisible () {
        $(byText("Show only advisers available for contact")).shouldBe(Condition.visible);
    }

    public int countResults() {
        return financialPlanningAdvisersResultsList.size();
    }

    public boolean findParticularAdviserInSearchResults(String adviserName) {
        boolean isAdviserExist = false;
        for (SelenideElement adviser : financialPlanningAdvisersResultsList) {
            String name = adviser.getText();
            if (name.equalsIgnoreCase(adviserName)) {
                isAdviserExist = true;
                break;
            }
        }
        return isAdviserExist;
    }
}
