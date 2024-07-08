package ru.example.framework.playwright;

import com.microsoft.playwright.Page;

import static com.microsoft.playwright.options.WaitForSelectorState.VISIBLE;

public class PlaywrightConstants {
    public static final Page.WaitForSelectorOptions DEFAULT_VISIBLE_15S = new Page.WaitForSelectorOptions()
            .setState(VISIBLE)
            .setTimeout(15000);
}
