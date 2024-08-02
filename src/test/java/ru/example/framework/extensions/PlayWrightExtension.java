package ru.example.framework.extensions;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import ru.example.framework.basetests.playwrighttest.PlaywrightTest;

public class PlayWrightExtension implements AfterTestExecutionCallback {
    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        boolean testFailed = extensionContext.getExecutionException().isPresent();
        if (testFailed) {
            PlaywrightTest PlaywrightTest = (PlaywrightTest) extensionContext.getTestInstance().get();
            PlaywrightTest.screenshotPage("страницы при ошибке");
        }
    }
}
