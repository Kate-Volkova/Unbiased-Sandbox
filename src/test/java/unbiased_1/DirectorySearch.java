// Directory Search Page where we select filters

package unbiased_1;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class DirectorySearch {

    public void waitAction(int millsec) {
        Selenide.sleep(millsec);
    }

    public void clickItem(ElementsCollection itemsCollection, String itemName) {
        for (int i = 0; i <= itemsCollection.size(); i++) {
            SelenideElement itemInFocus = itemsCollection.get(i);
            String itemGetName = itemInFocus.getText();
            if (itemGetName.equalsIgnoreCase(itemName)) {
                itemInFocus.click();
                break;
            }

        }
    }

    public void setPostcodeValue(SelenideElement postcode, String postcodeValue) {
        postcode.val(postcodeValue);
    }

    public void submitRequest(SelenideElement submitButton) {
        submitButton.click();
    }

    public int countResults(ElementsCollection resultsList, SelenideElement visibleElement) {
        visibleElement.shouldBe(Condition.visible);
        int number = resultsList.size();
        return number;
    }

    public boolean findAdviser(ElementsCollection resultsList, String adviserName) {
        boolean trueFalse = false;
        for (int i = 0; i <= resultsList.size(); i++) {
            SelenideElement adviser = resultsList.get(i);
            String name = adviser.getText();
            if (name.equalsIgnoreCase(adviserName)) {
                trueFalse = true;
                break;
            }
            trueFalse = false;
        }
        return trueFalse;
    }
}
