package ru.example.projects.selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v127.network.Network;
import ru.example.framework.basetests.selenidetest.SelenideTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.codeborne.selenide.Selenide.*;

@Tag("selenide")
@DisplayName("Проект: Selenide")
public class SelTest extends SelenideTest {

    @Tag("run")
    @Test
    @DisplayName("1 : Тест первый")
    @Description("Описание")
    public void scenario() {

        aftStep("Открыть страницу", (action)-> {
            open("https://www.baeldung.com/get-started-with-java-series");
        });

        aftStep("Проверить страницу", (action)-> {
            $("[class=\"_3homga\"]").shouldBe(Condition.visible).click();
        });

//        aftStep("Клик на ссылку", (action)-> {
//            $x("//a[text() = 'Java']").shouldBe(Condition.visible).click();
//        });
    }
}
