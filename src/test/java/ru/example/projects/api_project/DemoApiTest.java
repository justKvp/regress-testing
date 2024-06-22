package ru.example.projects.api_project;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.example.projects.api_project.logic.DemoApiLogic;

@DisplayName("Проект: Demo api")
public class DemoApiTest {

    @Test
    @DisplayName("1 : Тест первый")
    @Description("Описание")
    @Tag("api")
    void simpleTest() {
        DemoApiLogic logic = new DemoApiLogic();
        logic.checkConfigFile();
    }
}
