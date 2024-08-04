/*
 * Copyright 2015-2023 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package ru.example.projects.playwright;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Response;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.example.framework.basetests.playwrighttest.PlaywrightTest;

import static ru.example.framework.playwright.PlaywrightConstants.DEFAULT_VISIBLE_15S;

@Tag("playwright")
@DisplayName("Проект: Demo playwright.dev")
class DemoPWTest extends PlaywrightTest {

    @Test
    @DisplayName("1 : Тест первый")
    @Description("Описание")
    void simpleTest(Page page) {
        page.navigate("https://www.baeldung.com/get-started-with-java-series");
        page.waitForSelector("[class=\"_3homga\"]", DEFAULT_VISIBLE_15S).click();

        Response response = page.waitForResponse("**/api/country-code/", () -> {
            page.waitForSelector("//a[text() = 'Java']").click();
        });

        System.out.println("RESPONSE: " + response.status());
    }
}
