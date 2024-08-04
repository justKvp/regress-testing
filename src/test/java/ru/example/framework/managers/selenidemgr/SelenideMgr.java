package ru.example.framework.managers.selenidemgr;

import com.codeborne.selenide.Configuration;
import jakarta.inject.Singleton;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.example.framework.config.selenide.SelenideCfg;
import ru.example.framework.config.selenoid.SelenoidCfg;
import ru.example.framework.managers.configmgr.ConfigMgr;

import static ru.example.framework.managers.selenidemgr.options.BrowserOptions.getDesiredCapabilities;

@Singleton
public class SelenideMgr {
    private static final Logger logger = LoggerFactory.getLogger("SelenideMgr");

    public static void initialize() {
        SelenideCfg selenideCfg = ConfigMgr.getConfig().getSelenide();
        SelenoidCfg selenoidCfg = ConfigMgr.getConfig().getSelenoid();

        if (selenoidCfg != null && !StringUtils.isEmpty(selenoidCfg.getRemote())) {
            Configuration.remote = selenoidCfg.getRemote();
        }
        else {
            if (!StringUtils.isEmpty(selenideCfg.getDriverBinary())) {
                String driverName = "chrome";
                switch (selenideCfg.getBrowser()) {
                    case "firefox": driverName = "gecko"; break;
                    case "ie": driverName = "ie"; break;
                    case "edge": driverName = "edge"; break;
                    default:
                        break;
                }
                System.getProperty(String.format("webdriver.%s.driver", driverName), selenideCfg.getDriverBinary());
            }

            if (!StringUtils.isEmpty(selenideCfg.getBrowserBinary()))
                Configuration.browserBinary = selenideCfg.getBrowserBinary();
        }

        Configuration.browser = selenideCfg.getBrowser();
        Configuration.browserSize = selenideCfg.getBrowserSize();
        Configuration.timeout = selenideCfg.getTimeout();
        Configuration.screenshots = selenideCfg.getScreenshots();
        Configuration.savePageSource = selenideCfg.getSavePageSource();
        if (!StringUtils.isEmpty(selenideCfg.getReportsFolder()))
            Configuration.reportsFolder = selenideCfg.getReportsFolder();

        DesiredCapabilities capabilities = getDesiredCapabilities(selenideCfg);
        Configuration.browserCapabilities = capabilities;
        logger.info("has been initialized successfully");
    }
}
