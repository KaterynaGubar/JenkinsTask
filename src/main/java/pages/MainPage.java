package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage extends BasePage {

    public LoginPage enterToPersonalArea() {
        $(byXpath("//*[@class='anonymous-user']/a[1]")).shouldBe(visible).click();

        return new LoginPage();
    }

    public String changeCity() {
        SelenideElement city = $(byClassName("city-selector")).shouldBe(visible);
        city.click();
        $(byXpath("//*[@id='citylist']/li[5]/a")).shouldHave(exactText("Харків")).click();

        return city.getText();
    }

    public boolean isOnMainPage() {
        return $(byXpath(".//*[@id='content']/div[1]/div[1]")).isDisplayed();
    }

    public ShowTimesPage goToShowTimesPage(){
        $$(byClassName("h-m__item-link")).findBy(text("Розклад")).click();

        return new ShowTimesPage();
    }
}
