package Tests;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.epam.Kateryna_Gubar.Page.MainPage;
import com.epam.Kateryna_Gubar.Page.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

import static com.codeborne.selenide.Condition.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SortAndFilterTest extends BaseTest{

    @Test
    public void searchInCategory() {
        MainPage mainPage = new MainPage();
        ElementsCollection namesOfProductsOnPage = mainPage
                .goToSubCategory("Электроника", "Мобильные телефоны")
                .searchInCategory("iphone")
                .getNamesOfProductsOnPage();
        for (SelenideElement str : namesOfProductsOnPage) {
            str.shouldHave(text("iphone"));
        }
    }

    @Test
    public void filterByPrice() {
        String priceMin = "1000";
        String priceMax = "3000";
        Set<Boolean> havePriceOutCostRange = new HashSet<>();

        MainPage mainPage = new MainPage();
        mainPage
                .goToSubCategory("Электроника", "Мобильные телефоны")
                .filterByPrice(priceMin, priceMax)
                .priceProductsOnPage()
                .iterator()
                .forEachRemaining(
                        priceProduct -> {
                            if (priceProduct < Integer.parseInt(priceMin) || priceProduct > Integer.parseInt(priceMax))
                                havePriceOutCostRange.add(true);
                        });
        Assert.assertFalse(havePriceOutCostRange.contains(true));
        ProductsPage productsPage = new ProductsPage();
        productsPage.cancelFiltrByPrice();
    }

    @Test
    public void sortByPriceAscending() {
        MainPage mainPage = new MainPage();
        List<Integer> actual = mainPage
                .goToSubCategory("Электроника", "Мобильные телефоны")
                .sortBy("цена от дешевых")
                .priceProductsOnPage();
        assertThat(actual).isSorted();
    }

    @Test
    public void sortByPriceDescending() {
        MainPage mainPage = new MainPage();
        List<Integer> actual = mainPage
                .goToSubCategory("Электроника", "Мобильные телефоны")
                .sortBy("цена от дорогих")
                .priceProductsOnPage();
        List<Integer> expected = new ArrayList<>(actual);
        expected.sort(Collections.reverseOrder());
        Assert.assertTrue(expected.equals(actual));
    }

    @Test
    public void shopsWithoutDeliveryFromOtherCities() {
        MainPage mainPage = new MainPage();
        mainPage
                .goToSubCategory("Электроника", "Мобильные телефоны")
                .openFirsProduct()
                .clikCheckboxDelivery()
                .iconDeliveryFromOtherCities()
                .shouldBe(not(visible));
    }

}
