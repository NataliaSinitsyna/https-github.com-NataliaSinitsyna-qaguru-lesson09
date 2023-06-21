package com.globalsqa;

import com.TestBase;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class UseCsvSource extends TestBase {

    @CsvSource(value = {
            "Shirley, Tanaka, E28440",
            "Ryan, Smith, E18610",
            "Angeline, Golden, E28440",
    })
    @ParameterizedTest
    public void csvSource(String firstName, String lastName, String postCode) {
        open("https://www.globalsqa.com/angularJs-protractor/BankingProject/");
        $(byText("Bank Manager Login")).click();
        $(byText("Add Customer")).click();
        $("[ng-model=fName]").setValue(firstName);
        $("[ng-model=lName]").setValue(lastName);
        $("[ng-model=postCd]").setValue(postCode);
        $(".marTop button").click();
        Selenide.confirm();

    }
}
