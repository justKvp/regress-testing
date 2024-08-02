package ru.example.framework.config.selenoid;

import lombok.Data;

@Data
public class SelenoidCfg {
    private String remote;
    private String reportsFolder;
    private int timeout;
}
