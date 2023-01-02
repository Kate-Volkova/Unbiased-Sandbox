package unbiased_1;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;

abstract public class BaseTest {
    public void setup() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false; // настройка для jenkins 'true', потому что нет монитора и браузера, всё виртуально
    }

    @Before
    public void init() {
        setup();
    }

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}