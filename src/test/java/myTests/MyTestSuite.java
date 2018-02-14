package myTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.PersonalAreaPage;
import pages.ShowTimesPage;

public class MyTestSuite extends BaseTest {

    @Test(priority = 0)
    public void successfulLoginTest() {
        MainPage mainPage = new MainPage();
        LoginPage loginPage = mainPage.enterToPersonalArea();
        PersonalAreaPage personalAreaPage = loginPage.login(email, pass);
        Assert.assertTrue(personalAreaPage.isLoggedIn());
    }

    @Test(priority = 1)
    public void goToMainPage() {
        MainPage mainPage = new MainPage();
        LoginPage loginPage = mainPage.enterToPersonalArea();
        PersonalAreaPage personalAreaPage = loginPage.login(email, pass);
        mainPage = personalAreaPage.goToMainPage();
        Assert.assertTrue(mainPage.isOnMainPage());
    }

    @Test(priority = 2)
    public void currentCityChange() {
        MainPage mainPage = new MainPage();
        String newCity = mainPage.changeCity();
        Assert.assertEquals(newCity, cityToChange);
    }

    @Test(priority = 3)
    public void currentDaysMovies() {
        MainPage mainPage = new MainPage();
        ShowTimesPage showTimesPage = mainPage.goToShowTimesPage();
        Assert.assertTrue(showTimesPage.isTodaysMoviesDisplayed());
    }

    @Test(priority = 4)
    public void only2dMoviesShown() {
        MainPage mainPage = new MainPage();
        ShowTimesPage showTimesPage = mainPage.goToShowTimesPage();
        showTimesPage.uncheck2dMovies();
        Assert.assertTrue(showTimesPage.is2dMoviesNotShown());
    }

    @Test(priority = 5)
    public void isToasterVisible() {
        MainPage mainPage = new MainPage();
        ShowTimesPage showTimesPage = mainPage.goToShowTimesPage();
        Assert.assertTrue(showTimesPage.isTosterPresent());
    }

    @Test(priority = 6)
    public void successfulLogout() {
        PersonalAreaPage personalAreaPage = new PersonalAreaPage();
        Assert.assertEquals(personalAreaPage.logout().loginHeader(), "Вхід в Особистий Кабінет");
    }

}
