package ru.example.framework.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import ru.example.framework.config.playwright.PlaywrightCfg;
import ru.example.framework.config.project.ProjectCfg;
import ru.example.framework.config.selenide.SelenideCfg;
import ru.example.framework.config.selenoid.SelenoidCfg;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Config {
    @JsonProperty("project")
    private ProjectCfg project;
    @JsonProperty("selenide")
    private SelenideCfg selenide;
    @JsonProperty("selenoid")
    private SelenoidCfg selenoid;
    @JsonProperty("playwright")
    private PlaywrightCfg playwright;
}
