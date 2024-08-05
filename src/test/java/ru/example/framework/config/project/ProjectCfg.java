package ru.example.framework.config.project;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProjectCfg {
    @JsonProperty("baseUrl")
    private String baseUrl;
    @JsonProperty("baseUrl2")
    private String baseUrl2;
    @JsonProperty("allureTMSUrl")
    private String allureTMSUrl;
}
