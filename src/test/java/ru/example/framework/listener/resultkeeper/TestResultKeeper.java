package ru.example.framework.listener.resultkeeper;

import jakarta.inject.Singleton;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestIdentifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import static ru.example.framework.managers.convertermgr.ConverterMgr.makeStringFromObject;

@Singleton
public class TestResultKeeper {
    private static final Logger logger = LoggerFactory.getLogger("TestResultKeeper");

    private static HashMap<String, SuiteResultData> tmpSuiteMap;

    /** обязательно Concurrent, тк при одновременном вызове при параллели можем потерять тест **/
    private static ConcurrentHashMap<String, TestResultData> tmpAllTestResultMap;

    private static List<SuiteResultData> exportSuiteList;
    private static Integer totalTests = 0;
    private static Integer passed = 0;
    private static Integer failed = 0;
    private static Integer aborted = 0;

    public static void initialize() {
        tmpSuiteMap = new HashMap<>();
        tmpAllTestResultMap = new ConcurrentHashMap<>();
        exportSuiteList = new ArrayList<>();
    }

    /** Добавление результата теста во временную concurrent hashmap **/
    public static void addTestResult(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
        if (testIdentifier.isTest()) {
            String name = testIdentifier.getDisplayName();
            String method = testIdentifier.getLegacyReportingName();

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

            tmpAllTestResultMap.put(name+suite, new TestResultData(name, method, suite, result, reason));
        }
    }

    public static void showResults() {
        logger.info("кол-во suites: " + exportSuiteList.size());

//        for (SuiteResultData suite : exportSuiteList) {
//            logger.info(String.format("кол-во тестов для suite [%s] = %d", suite.getSuiteName(), suite.getTestResultList().size()));
//
//            for (TestResultData testResult: suite.getTestResultList()) {
//                logger.info(testResult.toString());
//            }
//        }

        logger.info("Результаты в виде json: \n" + makeStringFromObject(new ExportData(totalTests, passed, failed, aborted, System.getProperty("buildUrl"), exportSuiteList)));
    }

    /** Перебор имеющихся suite, для формирования списка тестов в каждом **/
    public static void prepareTestResults() {
        for (TestResultData testResultData: tmpAllTestResultMap.values()) {
            String suiteName = testResultData.suite;
            getSuite(suiteName).addTestResult(testResultData);

            totalTests ++;
            switch (testResultData.result) {
                case "SUCCESSFUL": passed++; break;
                case "ABORTED": failed++; break;
                case "FAILED": aborted++; break;
                default:
                    break;
            }
        }

        prepareExportList();
    }

    /** взять suite по названию, если нет - создать новый **/
    private static SuiteResultData getSuite(String suiteName) {
        if (tmpSuiteMap.containsKey(suiteName)) {
            return tmpSuiteMap.get(suiteName);
        } else {
            /** if doesn't exist - need to create a new suite **/
            SuiteResultData createdSuite = new SuiteResultData(suiteName);
            tmpSuiteMap.put(suiteName, createdSuite);
            return createdSuite;
        }
    }

    /** экспорт suite с имеющимися списками тестов из мапы в List **/
    private static void prepareExportList() {
        for (SuiteResultData suite : tmpSuiteMap.values()) {
            exportSuiteList.add(suite);
        }

        /** cleanup **/
        tmpAllTestResultMap.clear();
        tmpSuiteMap.clear();
    }
}
