package ru.example.framework.managers.selenidemgr.options;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.example.framework.config.selenide.SelenideCfg;

public class BrowserOptions {
    public static DesiredCapabilities getDesiredCapabilities(SelenideCfg selenideCfg) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

        switch (selenideCfg.getBrowser()) {
            case "chrome":
                desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, getChromeOptions(selenideCfg));
                break;
            case "firefox":
                desiredCapabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, getFirefoxOptions());
                break;
            case "edge":
                desiredCapabilities.setCapability(EdgeOptions.CAPABILITY, getEdgeOptions(selenideCfg));
                break;
            case "ie":
                desiredCapabilities.setCapability(InternetExplorerOptions.IE_OPTIONS, getInternetExplorerOptions());
                break;
            default:
                break;
        }
        return desiredCapabilities;
    }

    private static ChromeOptions getChromeOptions(SelenideCfg selenideCfg) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--lang=" + selenideCfg.getLocale());
        chromeOptions.addArguments("--safebrowsing-disable-download-protection");
        chromeOptions.addArguments("--unsafely-disable-devtools-self-xss-warnings");
        chromeOptions.addArguments("--hide-crash-restore-bubble");
        return chromeOptions;
    }

    private static FirefoxOptions getFirefoxOptions() {
        return new FirefoxOptions()
                .setProfile(new FirefoxProfile())
                .setAcceptInsecureCerts(true)
                .addPreference("general.useragent.override",
                        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36");
    }

    private static EdgeOptions getEdgeOptions(SelenideCfg selenideCfg) {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--no-sandbox");
        edgeOptions.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36");
        edgeOptions.addArguments("--disable-dev-shm-usage");
        edgeOptions.addArguments("--disable-infobars");
        edgeOptions.addArguments("--disable-popup-blocking");
        edgeOptions.addArguments("--disable-notifications");
        edgeOptions.addArguments("--lang=" + selenideCfg.getLocale());
        edgeOptions.addArguments("--safebrowsing-disable-download-protection");
        edgeOptions.addArguments("--unsafely-disable-devtools-self-xss-warnings");
        edgeOptions.addArguments("--hide-crash-restore-bubble");
        return edgeOptions;
    }

    private static InternetExplorerOptions getInternetExplorerOptions() {
        return new InternetExplorerOptions();
    }
}
