package ua.com.alevel.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.PropertyKey;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FileService<T> {

    private final static Logger logger = LoggerFactory.getLogger(FileService.class);

    public T map(Class<T> targetType, Properties properties) {

        Field[] fields = targetType.getDeclaredFields();
        String propertyName;
        T t = null;

        try {
            t = targetType.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            logger.warn(e.getMessage());
        } catch (IllegalAccessException e) {
            logger.warn(e.getMessage());
        } catch (InvocationTargetException e) {
            logger.warn(e.getMessage());
        } catch (NoSuchMethodException e) {
            logger.warn(e.getMessage());
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

    public Properties getProperties() {
        Properties properties = new Properties();

        try(InputStream input = FileService.class.getResourceAsStream("/appProperties.properties")) {
            properties.load(input);
        } catch (IOException e) {
            logger.warn(e.getMessage());
        }
        return properties;
    }
}
