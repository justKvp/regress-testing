package ru.example.framework.listener.resultkeeper;

import java.util.List;

public class ExportData {
    private final Integer totalTests;
    private final Integer passed;
    private final Integer failed;
    private final Integer aborted;
    private final List<SuiteResultData> exportSuiteList;

    public ExportData(Integer totalTests, Integer passed, Integer failed, Integer aborted, List<SuiteResultData> exportSuiteList) {
        this.totalTests = totalTests;
        this.passed = passed;
        this.failed = failed;
        this.aborted = aborted;
        this.exportSuiteList = exportSuiteList;
    }
}
