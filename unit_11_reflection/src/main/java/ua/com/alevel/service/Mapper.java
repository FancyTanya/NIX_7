package ua.com.alevel.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.PropertyKey;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class Mapper {

    private final static Logger logger = LoggerFactory.getLogger(Mapper.class);

    public <T> T map(Class<T> targetType, Properties properties) {

        Field[] fields = targetType.getDeclaredFields();
        String propertyName;
        T t = null;

        try {
            t = targetType.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            logger.error("failed to construct the entity", e);
            throw new RuntimeException(e);
        }
        for (Field field: fields) {
            propertyName = field.getAnnotation(PropertyKey.class).value();
            if (properties.containsKey(propertyName)) {
                if (field.getType() == String.class) {
                    try {
                        field.set(t, properties.getProperty(propertyName));
                    } catch (IllegalAccessException e) {
                        logger.warn(e.getMessage());
                    }
                }
                if (field.getType() == int.class) {
                    try {
                        field.setInt(t, Integer.parseInt(properties.getProperty(propertyName)));
                    } catch (IllegalAccessException e) {
                        logger.warn(e.getMessage());
                    }
                }
                if (field.getType() == long.class) {
                    try {
                        field.setLong(t, Long.parseLong(properties.getProperty(propertyName)));
                    } catch (IllegalAccessException e) {
                        logger.warn(e.getMessage());
                    }
                }
                if (field.getType() == double.class) {
                    try {
                        field.setDouble(t, Double.parseDouble(properties.getProperty(propertyName)));
                    } catch (IllegalAccessException e) {
                        logger.warn(e.getMessage());
                    }
                }
                if (field.getType() == char.class) {
                    try {
                        field.setChar(t, properties.getProperty(propertyName).charAt(0));
                    } catch (IllegalAccessException e) {
                        logger.warn(e.getMessage());
                    }
                }
                if (field.getType() == boolean.class) {
                    try {
                        field.setBoolean(t, Boolean.getBoolean(properties.getProperty(propertyName)));
                    } catch (IllegalAccessException e) {
                        logger.warn(e.getMessage());
                    }
                }
            }
        }
        return t;
    }
}
