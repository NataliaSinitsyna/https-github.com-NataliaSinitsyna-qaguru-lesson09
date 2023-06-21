package com.saucedemo;

import com.TestBase;
import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.*;

public class UseValueSource extends TestBase {

    @ParameterizedTest
    @ValueSource(strings = {"Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt",
            "Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Test.allTheThings() T-Shirt (Red)"})
    public void valueSource(String value) {
        open("https://www.saucedemo.com/");
        $("#user-name").setValue("standard_user");
        $("#password").setValue("secret_sauce");
        $("#login-button").click();
        $$(".inventory_item_label a div").shouldHave(CollectionCondition.itemWithText(value));

    }
}
