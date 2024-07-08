package ru.example.framework.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.junit.Options;
import com.microsoft.playwright.junit.OptionsFactory;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class PWOptions implements OptionsFactory {
    @Override
    public Options getOptions() {
        Options options = new Options();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();

        // LaunchOptions
        if (!StringUtils.isEmpty(System.getProperty("browser"))) {
            options.setBrowserName(System.getProperty("browser"));
            switch (System.getProperty("browser")) {
                case "firefox":
                    Map<String, Object> firefoxUserPrefs = new HashMap<>();
                    firefoxUserPrefs.put("general.useragent.override", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36");
                    launchOptions.setFirefoxUserPrefs(firefoxUserPrefs);
                    break;
                case "webkit":
                    launchOptions.setTimeout(50000);
                    break;
                default:
                    break;
            }
        }
        options.setLaunchOptions(launchOptions);

        // headless mode
        boolean headless = StringUtils.isEmpty(System.getProperty("headless")) || Boolean.parseBoolean(System.getProperty("headless"));
        options.setHeadless(headless);

        // ContextOptions
        options.setContextOptions(new Browser.NewContextOptions()
                .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36")
                .setIgnoreHTTPSErrors(true)
        );

        options.setIgnoreHTTPSErrors(true);
        return options;
    }
}
