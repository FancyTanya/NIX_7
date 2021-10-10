package ua.com.alevel.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperties {
    private final static Logger logger = LoggerFactory.getLogger(GetProperties.class);

    public Properties getProperties(String path) {
        Properties properties = new Properties();

        try(InputStream input = Mapper.class.getResourceAsStream(path)) {
            properties.load(input);
        } catch (IOException e) {
            logger.warn(e.getMessage());
        }
        return properties;
    }
}
