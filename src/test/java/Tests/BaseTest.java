package Tests;

import com.codeborne.selenide.Configuration;
import core.DriverFactory;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;

import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {

    static RemoteWebDriver webDriver;

    @BeforeTest
    public void init() throws MalformedURLException {
        webDriver = DriverFactory.getDriver("chrome");
        webDriver.manage().window().maximize();

        Configuration.browser = "chrome";
    }

    @BeforeMethod
    public void openMainPage() {
        open("https://pn.com.ua/");
    }
}
