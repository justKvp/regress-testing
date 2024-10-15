package ru.example.framework.listener.resultkeeper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.ArrayList;

@JsonIgnoreProperties({ "suiteName" })
public class SuiteResultData {
    @Getter
    private final String suiteName;

    @Getter
    private final ArrayList<TestResultData> testResultList;

    public SuiteResultData(String suiteName) {
        this.suiteName = suiteName;
        this.testResultList = new ArrayList<>();
    }

    public void addTestResult(TestResultData testResultData) {
        testResultList.add(testResultData);
    }
}
