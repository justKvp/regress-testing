package ru.example.framework.selenide;

import com.codeborne.selenide.Configuration;
import jakarta.inject.Singleton;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.example.framework.config.Config;
import ru.example.framework.config.ConfigMgr;

@Singleton
public class SelenideMgr {
    private static final Logger logger = LoggerFactory.getLogger("SelenideMgr");

    public static void initialize() {
        Config config = ConfigMgr.getConfig();

        if (config.getSelenoid() != null) {
            Configuration.remote = config.getSelenoid().getRemote();
            Configuration.reportsFolder = config.getSelenoid().getReportsFolder();
            Configuration.timeout = config.getSelenoid().getTimeout();
        }
        else {
            if (!StringUtils.isEmpty(config.getProject().getDriverBinary()))
                System.getProperty("webdriver.chrome.driver", config.getProject().getDriverBinary());
            if (!StringUtils.isEmpty(config.getProject().getBrowserBinary()))
                Configuration.browserBinary = config.getProject().getBrowserBinary();
        }

        Configuration.browser = config.getProject().getBrowser();
        Configuration.browserSize = "1920x1080";
        Configuration.screenshots = false;
        Configuration.savePageSource = false;

        DesiredCapabilities capabilities = getDesiredCapabilities(config);
        Configuration.browserCapabilities = capabilities;
    }

    private static DesiredCapabilities getDesiredCapabilities(Config config) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--lang=" + config.getProject().getLocale());
        chromeOptions.addArguments("--safebrowsing-disable-download-protection");
        chromeOptions.addArguments("--unsafely-disable-devtools-self-xss-warnings");
        chromeOptions.addArguments("--hide-crash-restore-bubble");

        desiredCapabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        return desiredCapabilities;
    }
}
