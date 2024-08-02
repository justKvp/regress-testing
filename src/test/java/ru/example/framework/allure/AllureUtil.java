package ru.example.framework.allure;

import com.codeborne.selenide.Selenide;
import com.microsoft.playwright.Page;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;

public class AllureUtil {
    /**
     * Аннотацию @Step используется для регистрации данного сообщения журнала в Allure.
     *
     * @param message сообщение для входа в отчет allure
     */
    @Step("{0}")
    public static void logToAllure(String message) {}

    @Attachment(value = "Screenshot: {str}", type = "image/png")
    public static byte[] makePlaywrightScreenshot(Page page, String str) {
        return page.screenshot();
    }

    @Attachment(value = "Screenshot: {str}", type = "image/png")
    public static byte[] makeScreenshot(String str) {
        return Selenide.screenshot(OutputType.BYTES);
    }
}
