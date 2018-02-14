package myTests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.BasePage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

public abstract class BaseTest {
    private static final String domain = "https://planetakino.ua/";
    static final String cityToChange = "Харків";
    static final String email = "katgubar@yandex.ua";
    static final String pass = "Kateryna2507";
    static final String searchRequest = "pubg";

    @BeforeSuite
    public static void beforeSuite() {
        BasePage.setDomain(domain);
    }

    @BeforeMethod
    public static void beforeMethod(){
        open(domain);
    }

    @AfterMethod
    public static void afterMethod(){
        clearBrowserCache();
    }

}
