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
import static ru.example.framework.playwright.PlaywrightConstants.DEFAULT_VISIBLE_5S;

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
        page.waitForSelector("//*[@class='dk-sbol-button__text dk-sbol-button__text_size_md' and text()='Уже хочу карту!']", DEFAULT_VISIBLE_5S);
        Assertions.assertTrue(page.locator("//*[@class='dk-sbol-button__text dk-sbol-button__text_size_md' and text()='Уже хочу карту!']").isVisible());
        makeScreenshot(page, "страница");
    }
}
