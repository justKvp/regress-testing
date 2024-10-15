package ru.example.framework.listener;

import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.TestPlan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.example.framework.listener.resultkeeper.SuiteResultData;
import ru.example.framework.listener.resultkeeper.TestResultData;
import ru.example.framework.listener.resultkeeper.TestResultKeeper;
import ru.example.framework.managers.configmgr.ConfigMgr;
import ru.example.framework.managers.convertermgr.ConverterMgr;
import ru.example.framework.managers.databasemgr.DBMgr;
import ru.example.framework.managers.selenidemgr.SelenideMgr;

import java.util.Map;

public class CustomTestExecutionListener implements TestExecutionListener {
    private static final Logger logger = LoggerFactory.getLogger("Listener");

    public void testPlanExecutionStarted(TestPlan testPlan) {
        logger.info("testPlanExecutionStarted : " + testPlan.getRoots());
        ConfigMgr.initialize();
        TestResultKeeper.initialize();
        ConverterMgr.initialize();
        SelenideMgr.initialize();
        DBMgr.initialize();
    }

    public void testPlanExecutionFinished(TestPlan testPlan) {
        DBMgr.closeSessionFactoryIfNeed();
        logger.info("testPlanExecutionFinished");

        TestResultKeeper.prepareTestResults();
        //TestResultKeeper.showResults();
    }

    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
        TestResultKeeper.addTestResult(testIdentifier, testExecutionResult);
    }
}
