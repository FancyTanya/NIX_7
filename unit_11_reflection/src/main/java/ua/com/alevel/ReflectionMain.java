package ua.com.alevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.service.FileService;

import java.io.IOException;
import java.lang.reflect.Field;
import java.security.KeyStore;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ReflectionMain {

    private final static Logger logger = LoggerFactory.getLogger(FileService.class);

    public static void main(String[] args) {

        FileService fileService = new FileService();
        Properties properties = new FileService().getProperties();
        AppProperties appProperties = (AppProperties) fileService.map(AppProperties.class, properties);
        System.out.println(appProperties);
    }
}
