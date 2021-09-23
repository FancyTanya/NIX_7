package ua.com.alevel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.Properties;

public class ShortWayMain {

    private static final Logger logger = LoggerFactory.getLogger(ShortWayMain.class);

    public static void main(String[] args) {
        Properties properties = loadProperties();
    }

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStream input = ShortWayMain.class.getResourceAsStream("/jdbc.properties"))
        {
            properties.load(input);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return properties;
    }
}
