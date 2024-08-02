package ru.example.framework.extensions;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import ru.example.framework.basetests.BaseTest;
import ru.example.framework.postgres.dbmgr.DBMgr;

public class DatabaseExtension implements BeforeEachCallback, AfterEachCallback {
    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        BaseTest baseTest = (BaseTest) extensionContext.getTestInstance().get();
        baseTest.setDatabaseSession(DBMgr.createSession());
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        BaseTest baseTest = (BaseTest) extensionContext.getTestInstance().get();
        baseTest.closeDatabaseSession();
    }
}
