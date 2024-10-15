package ru.example.framework.listener.resultkeeper;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "name", "method", "suite", "result", "error" })
public class TestResultData {
    public final String name;
    public final String method;
    public final String suite;
    public final String result;
    public final String error;

    public TestResultData(String name, String method, String suite, String result, String error) {
        this.name = name;
        this.method = method;
        this.suite = suite;
        this.result = result;
        this.error = error;
    }

    @Override
    public String toString() {
        return "TestResultData{" +
                "name='" + name + '\'' +
                ", method='" + method + '\'' +
                ", suite='" + suite + '\'' +
                ", result='" + result + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}
