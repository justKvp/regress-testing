package ru.example.framework.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.junit.Options;
import com.microsoft.playwright.junit.OptionsFactory;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PWOptions implements OptionsFactory {
    @Override
    public Options getOptions() {
        Options options = new Options();

        // headless mode
        boolean headless = StringUtils.isEmpty(System.getProperty("headless")) || Boolean.parseBoolean(System.getProperty("headless"));
        options.setHeadless(headless);
        options.setIgnoreHTTPSErrors(true);
        options.setContextOptions(new Browser.NewContextOptions()
                .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36")
                .setIgnoreHTTPSErrors(true)
        );

        if (!StringUtils.isEmpty(System.getProperty("browser"))) {
            options.setBrowserName(System.getProperty("browser"));

            if (System.getProperty("browser").equals("firefox")) {
                Map<String, Object> firefoxUserPrefs = new HashMap<>();

//                firefoxUserPrefs.put("general.useragent.extra.firefox", null);
//                firefoxUserPrefs.put("general.useragent.extra.productName", null);
//                firefoxUserPrefs.put("general.useragent.locale", null);
//                firefoxUserPrefs.put("general.useragent.override", null);
//                firefoxUserPrefs.put("general.useragent.security", null);
                firefoxUserPrefs.put("general.useragent.override", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/92.0.4515.159 Safari/537.36");

                options.setLaunchOptions(new BrowserType.LaunchOptions()
                        .setFirefoxUserPrefs(firefoxUserPrefs)
                );
            }
        }

        return options;
    }
}
