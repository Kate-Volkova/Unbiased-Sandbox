// Directory Search Page where we select filters

package unbiased_1.page;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AdvisersServiceFinancialAdviserPage {
    private final ElementsCollection DropDownItemsCollection = $$x("//div[@tabindex=0]");
    private final static String ADVISE_ON_ITEM = "Financial planning";
    private final static String ASSET_ITEM = "£501,000+";
    private final SelenideElement postcodeTextField = $x("//input[@id=\"filter-select-postcode\"]");
    private final static String POSTCODE_VALUE = "SE207AA";
    private final SelenideElement submitButton = $x("//button[@id=\"filter-submit-button\"]");
    private final SelenideElement visibleElement = $(byText("Show only advisers available for contact"));
    private final ElementsCollection financialPlanningAdvisersResultsList = $$x("//h2");
    private final static String ADVISER_NAME = "The Private Office";

    public void selectFilterItem(String item) {
         for (int i = 0; i <= DropDownItemsCollection.size(); i++) {
                SelenideElement itemInFocus = DropDownItemsCollection.get(i);
                String itemGetName = itemInFocus.getText();
                if (itemGetName.equalsIgnoreCase(item)) {
                    itemInFocus.click();
                    break;
                }
         }
    }
    public void selectAdviseArea() {
        selectFilterItem(ADVISE_ON_ITEM);
    }

    public void selectIncome() {
        selectFilterItem(ASSET_ITEM);
    }

    public void setPostcodeValue() {
        postcodeTextField.val(POSTCODE_VALUE);
    }

    public void submitRequest() {
        submitButton.click();
    }

    public void checkIfVisible () {visibleElement.shouldBe(Condition.visible);}

    public int countResults() {
        return financialPlanningAdvisersResultsList.size();
    }

    public boolean findAdviser() {
        boolean trueFalse = false;
        for (int i = 0; i <= financialPlanningAdvisersResultsList.size(); i++) {
            SelenideElement adviser = financialPlanningAdvisersResultsList.get(i);
            String name = adviser.getText();
            if (name.equalsIgnoreCase(ADVISER_NAME)) {
                trueFalse = true;
                break;
            }
        }
        return trueFalse;
    }
}
