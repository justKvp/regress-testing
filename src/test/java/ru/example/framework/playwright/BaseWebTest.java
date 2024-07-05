package ru.example.framework.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import static ru.example.framework.allure.AllureUtil.makeScreenshot;

@UsePlaywright(PWOptions.class)
@ExtendWith(WebTestResultExtension.class)
public class BaseWebTest {
    private Page ptrPage;
    @Getter
    private String browserName;

    @BeforeEach
    public void beforeEach(Page page, Browser browser) {
        this.ptrPage = page;
        this.browserName = browser.browserType().name();
    }

    public void screenshotAfterFail() {
        makeScreenshot(ptrPage, "После теста");
    }
}
