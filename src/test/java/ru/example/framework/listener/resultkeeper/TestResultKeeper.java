package ru.example.framework.listener.resultkeeper;

import jakarta.inject.Singleton;
import lombok.Getter;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestIdentifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
public class TestResultKeeper {
    private static final Logger logger = LoggerFactory.getLogger("TestResultKeeper");

    private static HashMap<String, SuiteResultData> suiteMap;

    /** обязательно Concurrent, тк при одновременном вызове при параллели можем потерять тест **/
    private static ConcurrentHashMap<String, TestResultData> allTestResultMap;

    public static void initialize() {
        suiteMap = new HashMap<>();
        allTestResultMap = new ConcurrentHashMap<>();
    }

    public static void addTestResult(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
        if (testIdentifier.isTest()) {
            String name = testIdentifier.getDisplayName();

            /** suite name as class name **/
            String suite = "";
            String separator = "class:";
            if (testIdentifier.getParentId().isPresent()) {
                suite = testIdentifier.getParentId().get();
                suite = suite.substring(suite.indexOf(separator) + separator.length(), suite.lastIndexOf("]"));
            }

            /** test result **/
            String result = testExecutionResult.getStatus().toString();

            /** error msg if exist **/
            String reason = "";
            if (testExecutionResult.getThrowable().isPresent()) {
                reason = testExecutionResult.getThrowable().get().getMessage();
            }

            allTestResultMap.put(name+suite, new TestResultData(name, suite, result, reason));
        }
    }

    public static void filLTestsInSuites() {
        for (TestResultData testResultData: allTestResultMap.values()) {
            String suiteName = testResultData.suite;
            getSuite(suiteName).addTestResult(testResultData);
        }
    }

    public static void showResults() {
        logger.info("кол-во suites: " + suiteMap.size());

        for (SuiteResultData suite : suiteMap.values()) {
            logger.info(String.format("кол-во тестов для suite [%s] = %d", suite.getSuiteName(), suite.getTestResultList().size()));

            for (TestResultData testResult: suite.getTestResultList()) {
                logger.info(testResult.toString());
            }
        }
    }

    private static SuiteResultData getSuite(String suiteName) {
        if (suiteMap.containsKey(suiteName)) {
            return suiteMap.get(suiteName);
        } else {
            /** if doesn't exist - need to create a new suite **/
            SuiteResultData createdSuite = new SuiteResultData(suiteName);
            suiteMap.put(suiteName, createdSuite);
            return createdSuite;
        }
    }
}
