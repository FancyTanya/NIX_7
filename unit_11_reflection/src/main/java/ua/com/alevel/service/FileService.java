package ua.com.alevel.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.AppProperties;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class FileService {

    private final static Logger logger = LoggerFactory.getLogger(FileService.class);

    public Properties getFieldsFromFile() {
        Properties properties = new Properties();
        InputStream input = FileService.class.getResourceAsStream("/appProperties.properties");
        try {
            properties.load(input);
        } catch (IOException e) {
            logger.warn(e.getMessage());
        }
        return properties;
    }

    public AppProperties setFields() throws ClassNotFoundException
            , NoSuchMethodException, InvocationTargetException
            , InstantiationException, IllegalAccessException {
        Class appPropClass = Class.forName("ua.com.alevel.AppProperties");
        Constructor<AppProperties> constructor = appPropClass.getConstructor();
        AppProperties appProperties = constructor.newInstance();
        appProperties.
    }
}
