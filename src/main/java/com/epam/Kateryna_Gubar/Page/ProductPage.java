package com.epam.Kateryna_Gubar.Page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class ProductPage {

    public SelenideElement iconDeliveryFromOtherCities() {
        return $x("//*[@class='product-city']");
    }

    private SelenideElement checkboxDeliveryFromOtherCities() {
        return $x("//*[@class='checkbox checkbox-delivery']");
    }

    public ProductPage clikCheckboxDelivery() {
        checkboxDeliveryFromOtherCities().click();
        return page(ProductPage.class);
    }

}
