package ru.example.framework.components;

import io.qameta.allure.Step;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StepContext {
    private static final ThreadLocal<StepContext> INSTANCE = ThreadLocal.withInitial(StepContext::new);
    private final Map<Integer, Integer> context = new HashMap<>();

    static {
        INSTANCE.get().context.put(0, 0);
    }

    private int totalSteps = 0;
    private int level = -1;

    public static StepContext getInstance() {
        return INSTANCE.get();
    }

    public void setTotalSteps(Integer steps) {
        totalSteps = steps;
    }

    public Integer getTotalSteps() {
        return totalSteps;
    }

    public Integer getSuccessfulSteps() {
        return context.get(0);
    }

    public void clearContext() {
        context.clear();
        context.put(0, 0);
        level = -1;
        totalSteps = 0;
    }

    public String getStep() {
        String message = "На шаге ";
        return message + getStepNum() + ". ";
    }

    public void calculate() {
        int size = context.size();
        int diff = (level + 1) - size;
        if (diff < -1) {
            for (int i = level + 1; i < size; i++) {
                context.remove(i);
                diff = 0;
            }
        }
        int newNum;

        switch (diff) {
            case 1:
                context.put(level, 1);
                break;
            case 0:
                newNum = context.get(level) + 1;
                context.put(level, newNum);
                break;
            case -1:
                context.remove(level + 1);
                newNum = context.get(level) + 1;
                context.put(level, newNum);
                break;
            default:
                throw new RuntimeException("level changed for more than 1");
        }
    }

    public void aftStep(final String message, WrappableStep action) {
        beforeStep();
        stepWithMessage(getStepNum() + ". " + message, action);
        afterStep();
    }

    public void aftStep(int sepNo, final String message, WrappableStep action) {
        level = 0;
        context.clear();
        context.put(level, sepNo);
        stepWithMessage(getStepNum() + ". " + message, action);
        context.clear();
        context.put(0, sepNo);
        afterStep();
    }

    @Step("{0}")
    private void stepWithMessage(final String message, WrappableStep action) {
        try {
            action.wrapStep(message);
        } catch (ParseException | InterruptedException | IOException | AWTException e) {
            e.printStackTrace();
        }
    }

    private void afterStep() {
        level--;
    }

    private void beforeStep() {
        level++;
        calculate();
    }

    @NotNull
    private String getStepNum() {
        return context.values()
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining("."));
    }
}
