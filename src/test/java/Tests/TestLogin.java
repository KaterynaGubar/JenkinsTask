package Tests;

import com.epam.Kateryna_Gubar.Page.LoginForm;
import com.epam.Kateryna_Gubar.Page.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.url;

public class TestLogin extends BaseTest {
    @Test
    public void invalidLogin() {
        MainPage mainPage = new MainPage();
        LoginForm loginForm = mainPage.openLoginForm();
        loginForm.logining("qwerty@qwerty.com", "12345678");
        loginForm.loginErrorMassage().shouldBe(visible);
    }

    @Test
    public void loginWithGoogle() {
        MainPage mainPage = new MainPage();
        LoginForm loginForm = mainPage.openLoginForm();
        loginForm.loginWithGoogle();
        switchTo().window(1);
        Assert.assertTrue(url().contains("google"));
        close();
    }

    @Test
    public void loginWithFacebook() {
        MainPage mainPage = new MainPage();
        LoginForm loginForm = mainPage.openLoginForm();
        loginForm.loginWithFacebook();
        switchTo().window(1);
        Assert.assertTrue(url().contains("facebook"));
        close();
    }

    @Test
    public void changeCity() {
        MainPage mainPage = new MainPage();
        mainPage.changeCity()
                .changeCityButton()
                .shouldHave(text("Днепр"));
    }

}
