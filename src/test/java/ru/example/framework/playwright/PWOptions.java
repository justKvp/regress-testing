package ru.example.framework.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.junit.Options;
import com.microsoft.playwright.junit.OptionsFactory;
import org.apache.commons.lang3.StringUtils;

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
        }

        return options;
    }
}
