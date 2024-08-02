package ru.example.framework.selenide;

import com.codeborne.selenide.Configuration;
import jakarta.inject.Singleton;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.example.framework.config.ConfigMgr;
import ru.example.framework.config.selenide.SelenideCfg;
import ru.example.framework.config.selenoid.SelenoidCfg;

@Singleton
public class SelenideMgr {
    private static final Logger logger = LoggerFactory.getLogger("SelenideMgr");

    public static void initialize() {
        SelenideCfg config = ConfigMgr.getConfig().getSelenide();
        SelenoidCfg selenoidCfg = ConfigMgr.getConfig().getSelenoid();

        Configuration.browser = config.getBrowser();
        Configuration.browserSize = config.getBrowserSize();
        Configuration.timeout = config.getTimeout();
        Configuration.screenshots = config.getScreenshots();
        Configuration.savePageSource = config.getSavePageSource();

        if (!StringUtils.isEmpty(config.getReportsFolder()))
            Configuration.reportsFolder = config.getReportsFolder();

        if (selenoidCfg != null) {
            Configuration.remote = selenoidCfg.getRemote();
        }
        else {
            if (!StringUtils.isEmpty(config.getDriverBinary()))
                System.getProperty("webdriver.chrome.driver", config.getDriverBinary());
            if (!StringUtils.isEmpty(config.getBrowserBinary()))
                Configuration.browserBinary = config.getBrowserBinary();
        }

        DesiredCapabilities capabilities = getDesiredCapabilities(config);
        Configuration.browserCapabilities = capabilities;
    }

    private static DesiredCapabilities getDesiredCapabilities(SelenideCfg config) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--lang=" + config.getLocale());
        chromeOptions.addArguments("--safebrowsing-disable-download-protection");
        chromeOptions.addArguments("--unsafely-disable-devtools-self-xss-warnings");
        chromeOptions.addArguments("--hide-crash-restore-bubble");

        desiredCapabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        return desiredCapabilities;
    }
}
