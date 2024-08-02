package ru.example.projects.selenide;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.example.framework.basetests.selenidetest.SelenideTest;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Tag("selenide")
@DisplayName("Проект: Selenide")
public class SelTest extends SelenideTest {

    @Tag("run")
    @Test
    @DisplayName("1 : Тест первый")
    @Description("Описание")
    public void scenario() {

        aftStep("Открыть страницу", (action)-> {
            open("https://www.baeldung.com/logback");
        });

        aftStep("Проверить страницу", (action)-> {
            $("#zddnuw").shouldBe(Condition.visible).$("span").click();
            $("#bd-example").shouldBe(Condition.visible);
        });
    }
}
