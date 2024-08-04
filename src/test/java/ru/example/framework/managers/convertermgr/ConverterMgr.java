package ru.example.framework.managers.convertermgr;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jakarta.inject.Singleton;
import lombok.SneakyThrows;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class ConverterMgr {
    private static final Logger logger = LoggerFactory.getLogger("ConverterMgr");
    private static ObjectMapper objectMapper;

    public static void initialize() {
        objectMapper = new ObjectMapper();
        objectMapper.setVisibility(objectMapper.getSerializationConfig().getDefaultVisibilityChecker()
                .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
        objectMapper.findAndRegisterModules();
        logger.info("has been initialized successfully");
    }

    /**
     * Возвращает объект нужного класса из текста (json/xml)
     **/
    @SneakyThrows
    public static <T> T makeObjectFromString(String json, Class<T> className) {
        return objectMapper.readValue(json, className);
    }

    /**
     * Возвращает объект в виде красивого текста (json или xml)
     **/
    @SneakyThrows
    public static String makeStringFromObject(Object obj) {
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        return objectMapper.writeValueAsString(obj);
    }

    /**
     * Возвращает объект в виде простого текста (без табуляции (json в виде 1 строки))
     **/
    @SneakyThrows
    public static String makeSimpleStringFromObject(Object obj) {
        objectMapper.disable(SerializationFeature.INDENT_OUTPUT);
        return objectMapper.writeValueAsString(obj);
    }

    public static JSONObject makeJSONFromString(String stringJson) {
        return new JSONObject(stringJson);
    }
}
