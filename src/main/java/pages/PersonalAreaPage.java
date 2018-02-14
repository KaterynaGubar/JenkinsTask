package pages;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PersonalAreaPage extends BasePage {

    public LoginPage logout() {
        $(byXpath(".//*[@class='authorised-user']/a[2]")).shouldBe(visible).click();

        return new LoginPage();
    }

    public boolean isLoggedIn() {
        return $(byXpath(".//*[@id='page-content']/h1")).is(exist);
    }

    public MainPage goToMainPage(){
        $(byId("logo")).should(exist).click();

        return new MainPage();
    }
}
