package ru.example.framework.config.playwright;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PlaywrightCfg {
    @JsonProperty("browser")
    private String browser;
    @JsonProperty("width")
    private Integer width;
    @JsonProperty("height")
    private Integer height;
    @JsonProperty("locale")
    private String locale;
    @JsonProperty("timeout")
    private Integer timeout;
    @JsonProperty("headless")
    private Boolean headless;
}
