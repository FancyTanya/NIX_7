package ua.com.alevel;
import ua.com.alevel.service.FileService;

import java.lang.reflect.Field;
import java.security.KeyStore;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ReflectionMain {

    public static void main(String[] args) {
        Properties properties = new FileService().getFieldsFromFile();

        Set<Map.Entry<Object, Object>> entrySet = properties.entrySet();

        Factory<AppProperties> factory = new Factory<>();

        AppProperties app = new AppProperties();
        Class appClass = app.getClass();
        Field[] fields = appClass.getDeclaredFields();
        for (Field myField: fields) {
            AppProperties map = factory.map(appClass, properties);
        }

        for (Object obj: properties.entrySet()) {

        }
    }
}
