package ua.com.alevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.service.GetProperties;
import ua.com.alevel.service.Mapper;

import java.util.Properties;

public class ReflectionMain {

    private final static Logger logger = LoggerFactory.getLogger(Mapper.class);

    public static void main(String[] args) {

        String path = "unit_11_reflection/appProperties.properties";
        Mapper mapper = new Mapper();
        Properties properties = new GetProperties().getProperties(path);
        AppProperties appProperties = mapper.map(AppProperties.class, properties);
        System.out.println(appProperties);
    }
}
