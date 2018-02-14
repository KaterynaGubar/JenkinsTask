package pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {

    public PersonalAreaPage login(String email, String pass) {
        $(byId("txtEmail")).shouldBe(visible).clear();
        $(byId("txtEmail")).shouldBe(visible).val(email);
        $(byId("password")).shouldBe(visible).val(pass);
        $(byXpath(".//*[@class='form-action']/input")).shouldBe(visible).click();

        return new PersonalAreaPage();
    }

    public String loginHeader(){
        return $(byXpath("//*[@class='col2']/h1")).getText();
    }
}
