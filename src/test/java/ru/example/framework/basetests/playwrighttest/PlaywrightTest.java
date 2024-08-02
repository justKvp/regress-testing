package ru.example.framework.basetests.playwrighttest;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.example.framework.allure.AllureUtil;
import ru.example.framework.basetests.BaseTest;
import ru.example.framework.extensions.PlayWrightExtension;
import ru.example.framework.playwright.PWOptions;

@UsePlaywright(PWOptions.class)
@ExtendWith(PlayWrightExtension.class)
public class PlaywrightTest extends BaseTest {
    private Page ptrPage;
    @Getter
    private String browserName;

    @BeforeEach
    public void beforeEach(Page page, Browser browser) {
        this.ptrPage = page;
        this.browserName = browser.browserType().name();
    }

    public void screenshotPage(String screenName) {
        AllureUtil.makePlaywrightScreenshot(ptrPage, screenName);
    }
}
