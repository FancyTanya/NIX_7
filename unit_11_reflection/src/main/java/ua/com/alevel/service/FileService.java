package ua.com.alevel.service;


import ua.com.alevel.AppProperties;
import ua.com.alevel.PropertyKey;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FileService {

    public void setFields() throws ClassNotFoundException, IOException, IllegalAccessException {
        Properties properties = new Properties();
        InputStream input = FileService.class.getResourceAsStream("/appProperties.properties");
        if (input != null) {
            properties.load(input);
        } else {
            throw new FileNotFoundException("file not founded");
        }
        Field[] annotatedFields = findAnnotatedFields(Class.forName("ua.com.alevel.AppProperties"), PropertyKey.class);
        for (Field field: annotatedFields) {
            if (field.getType() == String.class) {
                    field.set(AppProperties.class, properties.getProperty("property.string"));
            }
            if (field.getType() == int.class) {
                field.set(AppProperties.class, properties.getProperty("property.int"));
            }
            if (field.getType() == long.class) {
                field.set(AppProperties.class, properties.getProperty("property.long"));
            }
            if (field.getType() == double.class) {
                field.set(AppProperties.class, properties.getProperty("property.double"));
            }
            if (field.getType() == char.class) {
                field.set(AppProperties.class, properties.getProperty("property.char"));
            }
            if (field.getType() == boolean.class) {
                field.set(AppProperties.class, properties.getProperty("property.boolean"));
            }
        }
    }


    public static Field[] findAnnotatedFields(Class<?> clazz, Class<? extends Annotation> annotationClass) {
        Field[] declaredFields = clazz.getDeclaredFields();
        List<Field> annotatedFields = new ArrayList<>(declaredFields.length);
        for (Field field: declaredFields) {
            if (field.isAnnotationPresent(annotationClass)) {
                annotatedFields.add(field);
            }
        }
        return annotatedFields.toArray(new Field[annotatedFields.size()]);
    }
}
