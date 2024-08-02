package ru.example.framework.basetests.selenidetest;

import org.junit.jupiter.api.extension.ExtendWith;
import ru.example.framework.allure.AllureUtil;
import ru.example.framework.basetests.BaseTest;
import ru.example.framework.extensions.SelenideExtension;

@ExtendWith(SelenideExtension.class)
public class SelenideTest extends BaseTest {

    public void screenshotPage(String screenName) {
        AllureUtil.makeScreenshot(screenName);
    }
}
