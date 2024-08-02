package ru.example.framework.config.selenide;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SelenideCfg {
    @JsonProperty("browser")
    private String browser;
    @JsonProperty("browserSize")
    private String browserSize;
    @JsonProperty("locale")
    private String locale;
    @JsonProperty("timeout")
    private Integer timeout;

    @JsonProperty("browserBinary")
    private String browserBinary;
    @JsonProperty("driverBinary")
    private String driverBinary;

    @JsonProperty("reportsFolder")
    private String reportsFolder;
    @JsonProperty("screenshots")
    private Boolean screenshots;
    @JsonProperty("savePageSource")
    private Boolean savePageSource;
}
