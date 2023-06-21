package com.demoblaze;

import com.TestBase;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class UseMethodSource extends TestBase {

    static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of("Phones", List.of("Samsung galaxy s6", "Nokia lumia 1520", "Nexus 6",
                        "Samsung galaxy s7", "Iphone 6 32gb", "Sony xperia z5", "HTC One M9")),
                Arguments.of("Laptops", List.of("Sony vaio i5", "Sony vaio i7", "MacBook air",
                        "Dell i7 8gb", "2017 Dell 15.6 Inch", "MacBook Pro")),
                Arguments.of("Monitors", List.of("Apple monitor 24", "ASUS Full HD"))
                );
    }

    @MethodSource
    @ParameterizedTest
    void methodSource(String Categories, List<String> expectedDevices) {
        open("https://www.demoblaze.com/");
        $(byText(Categories)).click();
        $$(".card-title a").filter(visible).should(texts(expectedDevices));

    }
}
