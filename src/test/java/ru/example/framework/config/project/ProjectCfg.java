package ru.example.framework.config.project;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProjectCfg {
    @JsonProperty("baseUrl")
    private String baseUrl;
    @JsonProperty("baseUrl2")
    private String baseUrl2;

    @JsonProperty("browser")
    private String browser;
    @JsonProperty("locale")
    private String locale;

    @JsonProperty("browserBinary")
    private String browserBinary;
    @JsonProperty("driverBinary")
    private String driverBinary;

    @JsonProperty("allureTMSUrl")
    private String allureTMSUrl;

    @JsonProperty("datasource")
    private String datasource;
}
