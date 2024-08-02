package ru.example.framework.listener;

import org.apache.commons.lang3.StringUtils;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestPlan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.example.framework.config.ConfigMgr;
import ru.example.framework.converter.ConverterMgr;
import ru.example.framework.postgres.dbmgr.DBMgr;
import ru.example.framework.selenide.SelenideMgr;

public class CustomTestExecutionListener implements TestExecutionListener {
    private static final Logger logger = LoggerFactory.getLogger("Listener");

    public void testPlanExecutionStarted(TestPlan testPlan) {
        logger.info("testPlanExecutionStarted : " + testPlan.getRoots());
        ConfigMgr.initialize();
        ConverterMgr.initialize();
        SelenideMgr.initialize();
        if (!StringUtils.isEmpty(ConfigMgr.getConfig().getProject().getDatasource()))
            DBMgr.initialize(ConfigMgr.getConfig().getProject().getDatasource());
    }

    public void testPlanExecutionFinished(TestPlan testPlan) {
        DBMgr.closeSessionFactory();
        logger.info("testPlanExecutionStarted : " + testPlan.getRoots());
    }
}
