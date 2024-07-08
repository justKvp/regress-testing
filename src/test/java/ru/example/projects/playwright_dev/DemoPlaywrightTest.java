/*
 * Copyright 2015-2023 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package ru.example.projects.playwright_dev;

import com.microsoft.playwright.Page;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.example.framework.playwright.BaseWebTest;
import ru.example.projects.playwright_dev.logic.DemoPlaywrightLogic;

import static ru.example.framework.allure.AllureUtil.logToAllure;
import static ru.example.framework.allure.AllureUtil.makeScreenshot;
import static ru.example.framework.playwright.PlaywrightConstants.DEFAULT_VISIBLE_15S;

@DisplayName("Проект: Demo playwright.dev")
class DemoPlaywrightTest extends BaseWebTest {

    @Test
    @DisplayName("1 : Тест первый")
    @Description("Описание")
    @Tag("playwright")
    void simpleTest(Page page) {
        DemoPlaywrightLogic logic = new DemoPlaywrightLogic(page);
        logic.openPage("https://playwright.dev/");
        logic.clickButtonGetStarted();
        logic.checkNextPage();
        makeScreenshot(page, "страница");
        logToAllure("Browser: " + getBrowserName());
    }

    @Test
    @DisplayName("2 : Тест второй")
    @Description("Описание")
    @Tag("playwright")
    void simpleTest2(Page page) {
        page.navigate("https://www.sberbank.ru/ru/person/persons");
        logToAllure("Browser: " + getBrowserName());
        page.waitForSelector("//*[@class='dk-sbol-button__text dk-sbol-button__text_size_md' and text()='Уже хочу карту!']", DEFAULT_VISIBLE_15S);
        Assertions.assertTrue(page.locator("//*[@class='dk-sbol-button__text dk-sbol-button__text_size_md' and text()='Уже хочу карту!']").isVisible());
        makeScreenshot(page, "страница");
    }

    @Test
    @DisplayName("3 : Тест первый")
    @Description("Описание")
    @Tag("playwright")
    void simpleTest3(Page page) {
        DemoPlaywrightLogic logic = new DemoPlaywrightLogic(page);
        logic.openPage("https://playwright.dev/");
        logic.clickButtonGetStarted();
        logic.checkNextPage();
        makeScreenshot(page, "страница");
        logToAllure("Browser: " + getBrowserName());
    }

    @Test
    @DisplayName("4 : Тест первый")
    @Description("Описание")
    @Tag("playwright")
    void simpleTest4(Page page) {
        DemoPlaywrightLogic logic = new DemoPlaywrightLogic(page);
        logic.openPage("https://playwright.dev/");
        logic.clickButtonGetStarted();
        logic.checkNextPage();
        makeScreenshot(page, "страница");
        logToAllure("Browser: " + getBrowserName());
    }

    @Test
    @DisplayName("5 : Тест первый")
    @Description("Описание")
    @Tag("playwright")
    void simpleTest5(Page page) {
        DemoPlaywrightLogic logic = new DemoPlaywrightLogic(page);
        logic.openPage("https://playwright.dev/");
        logic.clickButtonGetStarted();
        logic.checkNextPage();
        makeScreenshot(page, "страница");
        logToAllure("Browser: " + getBrowserName());
    }

    @Test
    @DisplayName("6 : Тест первый")
    @Description("Описание")
    @Tag("playwright")
    void simpleTest6(Page page) {
        DemoPlaywrightLogic logic = new DemoPlaywrightLogic(page);
        logic.openPage("https://playwright.dev/");
        logic.clickButtonGetStarted();
        logic.checkNextPage();
        makeScreenshot(page, "страница");
        logToAllure("Browser: " + getBrowserName());
    }

    @Test
    @DisplayName("7 : Тест первый")
    @Description("Описание")
    @Tag("playwright")
    void simpleTest7(Page page) {
        DemoPlaywrightLogic logic = new DemoPlaywrightLogic(page);
        logic.openPage("https://playwright.dev/");
        logic.clickButtonGetStarted();
        logic.checkNextPage();
        makeScreenshot(page, "страница");
        logToAllure("Browser: " + getBrowserName());
    }

    @Test
    @DisplayName("8 : Тест первый")
    @Description("Описание")
    @Tag("playwright")
    void simpleTest8(Page page) {
        DemoPlaywrightLogic logic = new DemoPlaywrightLogic(page);
        logic.openPage("https://playwright.dev/");
        logic.clickButtonGetStarted();
        logic.checkNextPage();
        makeScreenshot(page, "страница");
        logToAllure("Browser: " + getBrowserName());
    }

    @Test
    @DisplayName("9 : Тест первый")
    @Description("Описание")
    @Tag("playwright")
    void simpleTest9(Page page) {
        DemoPlaywrightLogic logic = new DemoPlaywrightLogic(page);
        logic.openPage("https://playwright.dev/");
        logic.clickButtonGetStarted();
        logic.checkNextPage();
        makeScreenshot(page, "страница");
        logToAllure("Browser: " + getBrowserName());
    }

    @Test
    @DisplayName("10 : Тест первый")
    @Description("Описание")
    @Tag("playwright")
    void simpleTest10(Page page) {
        DemoPlaywrightLogic logic = new DemoPlaywrightLogic(page);
        logic.openPage("https://playwright.dev/");
        logic.clickButtonGetStarted();
        logic.checkNextPage();
        makeScreenshot(page, "страница");
        logToAllure("Browser: " + getBrowserName());
    }

    @Test
    @DisplayName("11 : Тест первый")
    @Description("Описание")
    @Tag("playwright")
    void simpleTest11(Page page) {
        DemoPlaywrightLogic logic = new DemoPlaywrightLogic(page);
        logic.openPage("https://playwright.dev/");
        logic.clickButtonGetStarted();
        logic.checkNextPage();
        makeScreenshot(page, "страница");
        logToAllure("Browser: " + getBrowserName());
    }

    @Test
    @DisplayName("12 : Тест первый")
    @Description("Описание")
    @Tag("playwright")
    void simpleTest12(Page page) {
        DemoPlaywrightLogic logic = new DemoPlaywrightLogic(page);
        logic.openPage("https://playwright.dev/");
        logic.clickButtonGetStarted();
        logic.checkNextPage();
        makeScreenshot(page, "страница");
        logToAllure("Browser: " + getBrowserName());
    }


    @Test
    @DisplayName("13 : Тест первый")
    @Description("Описание")
    @Tag("playwright")
    void simpleTest13(Page page) {
        DemoPlaywrightLogic logic = new DemoPlaywrightLogic(page);
        logic.openPage("https://playwright.dev/");
        logic.clickButtonGetStarted();
        logic.checkNextPage();
        makeScreenshot(page, "страница");
        logToAllure("Browser: " + getBrowserName());
    }

    @Test
    @DisplayName("14 : Тест второй")
    @Description("Описание")
    @Tag("playwright")
    void simpleTest14(Page page) {
        page.navigate("https://www.sberbank.ru/ru/person/persons");
        logToAllure("Browser: " + getBrowserName());
        page.waitForSelector("//*[@class='dk-sbol-button__text dk-sbol-button__text_size_md' and text()='Уже хочу карту!']", DEFAULT_VISIBLE_15S);
        Assertions.assertTrue(page.locator("//*[@class='dk-sbol-button__text dk-sbol-button__text_size_md' and text()='Уже хочу карту!']").isVisible());
        makeScreenshot(page, "страница");
    }

    @Test
    @DisplayName("15 : Тест первый")
    @Description("Описание")
    @Tag("playwright")
    void simpleTest15(Page page) {
        DemoPlaywrightLogic logic = new DemoPlaywrightLogic(page);
        logic.openPage("https://playwright.dev/");
        logic.clickButtonGetStarted();
        logic.checkNextPage();
        makeScreenshot(page, "страница");
        logToAllure("Browser: " + getBrowserName());
    }

    @Test
    @DisplayName("16 : Тест первый")
    @Description("Описание")
    @Tag("playwright")
    void simpleTest16(Page page) {
        DemoPlaywrightLogic logic = new DemoPlaywrightLogic(page);
        logic.openPage("https://playwright.dev/");
        logic.clickButtonGetStarted();
        logic.checkNextPage();
        makeScreenshot(page, "страница");
        logToAllure("Browser: " + getBrowserName());
    }

    @Test
    @DisplayName("17 : Тест первый")
    @Description("Описание")
    @Tag("playwright")
    void simpleTest17(Page page) {
        DemoPlaywrightLogic logic = new DemoPlaywrightLogic(page);
        logic.openPage("https://playwright.dev/");
        logic.clickButtonGetStarted();
        logic.checkNextPage();
        makeScreenshot(page, "страница");
        logToAllure("Browser: " + getBrowserName());
    }

    @Test
    @DisplayName("18 : Тест первый")
    @Description("Описание")
    @Tag("playwright")
    void simpleTest18(Page page) {
        DemoPlaywrightLogic logic = new DemoPlaywrightLogic(page);
        logic.openPage("https://playwright.dev/");
        logic.clickButtonGetStarted();
        logic.checkNextPage();
        makeScreenshot(page, "страница");
        logToAllure("Browser: " + getBrowserName());
    }

    @Test
    @DisplayName("19 : Тест первый")
    @Description("Описание")
    @Tag("playwright")
    void simpleTest19(Page page) {
        DemoPlaywrightLogic logic = new DemoPlaywrightLogic(page);
        logic.openPage("https://playwright.dev/");
        logic.clickButtonGetStarted();
        logic.checkNextPage();
        makeScreenshot(page, "страница");
        logToAllure("Browser: " + getBrowserName());
    }

    @Test
    @DisplayName("20 : Тест первый")
    @Description("Описание")
    @Tag("playwright")
    void simpleTest20(Page page) {
        DemoPlaywrightLogic logic = new DemoPlaywrightLogic(page);
        logic.openPage("https://playwright.dev/");
        logic.clickButtonGetStarted();
        logic.checkNextPage();
        makeScreenshot(page, "страница");
        logToAllure("Browser: " + getBrowserName());
    }

    @Test
    @DisplayName("21 : Тест первый")
    @Description("Описание")
    @Tag("playwright")
    void simpleTest21(Page page) {
        DemoPlaywrightLogic logic = new DemoPlaywrightLogic(page);
        logic.openPage("https://playwright.dev/");
        logic.clickButtonGetStarted();
        logic.checkNextPage();
        makeScreenshot(page, "страница");
        logToAllure("Browser: " + getBrowserName());
    }

    @Test
    @DisplayName("22 : Тест первый")
    @Description("Описание")
    @Tag("playwright")
    void simpleTest22(Page page) {
        DemoPlaywrightLogic logic = new DemoPlaywrightLogic(page);
        logic.openPage("https://playwright.dev/");
        logic.clickButtonGetStarted();
        logic.checkNextPage();
        makeScreenshot(page, "страница");
        logToAllure("Browser: " + getBrowserName());
    }

    @Test
    @DisplayName("23 : Тест первый")
    @Description("Описание")
    @Tag("playwright")
    void simpleTest23(Page page) {
        DemoPlaywrightLogic logic = new DemoPlaywrightLogic(page);
        logic.openPage("https://playwright.dev/");
        logic.clickButtonGetStarted();
        logic.checkNextPage();
        makeScreenshot(page, "страница");
        logToAllure("Browser: " + getBrowserName());
    }

    @Test
    @DisplayName("24 : Тест первый")
    @Description("Описание")
    @Tag("playwright")
    void simpleTest24(Page page) {
        DemoPlaywrightLogic logic = new DemoPlaywrightLogic(page);
        logic.openPage("https://playwright.dev/");
        logic.clickButtonGetStarted();
        logic.checkNextPage();
        makeScreenshot(page, "страница");
        logToAllure("Browser: " + getBrowserName());
    }
}
