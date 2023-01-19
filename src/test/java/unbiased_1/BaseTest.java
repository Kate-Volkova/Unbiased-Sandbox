package unbiased_1;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;

abstract public class BaseTest {
    public void setup() {
        Configuration.browserSize = "1920x1080";
    }

    @Before
    public void initBase() {
        setup();
    }

        @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
