package ru.example.framework.components;

import java.awt.*;
import java.io.IOException;
import java.text.ParseException;

public interface WrappableStep {
    void wrapStep(String stepName) throws ParseException, InterruptedException, IOException, AWTException;
}
