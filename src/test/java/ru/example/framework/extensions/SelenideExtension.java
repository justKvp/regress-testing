package ru.example.framework.extensions;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import ru.example.framework.basetests.selenidetest.SelenideTest;

public class SelenideExtension implements BeforeEachCallback, AfterEachCallback, AfterTestExecutionCallback {
    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        Allure.step("Завершение теста", ()-> {
            if (WebDriverRunner.hasWebDriverStarted())
                Selenide.closeWebDriver();
        });
    }

    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        boolean isTestFailed = extensionContext.getExecutionException().isPresent();
        if (isTestFailed) {
            SelenideTest selenideTest = (SelenideTest) extensionContext.getTestInstance().get();
            selenideTest.screenshotPage("страницы при ошибке");
        }
    }
}
