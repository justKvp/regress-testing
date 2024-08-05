package ru.example.framework.config.database;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DatabaseCfg {
    @JsonProperty("datasource")
    private String datasource;
}
