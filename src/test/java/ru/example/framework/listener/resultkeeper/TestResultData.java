package ru.example.framework.listener.resultkeeper;

public class TestResultData {
    public final String name;
    public final String suite;
    public final String result;
    public final String error;

    public TestResultData(String name, String suite, String result, String error) {
        this.name = name;
        this.suite = suite;
        this.result = result;
        this.error = error;
    }

    @Override
    public String toString() {
        return "TestResultData{" +
                "name='" + name + '\'' +
                ", suite='" + suite + '\'' +
                ", result='" + result + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}
