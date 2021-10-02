package ua.com.alevel.service;

import ua.com.alevel.annotation.MapperCSV;
import ua.com.alevel.entity.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Mapper {

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

    public void setFields(String pathFile) throws ClassNotFoundException, IOException, IllegalAccessException {
        Properties properties = new Properties();
        InputStream input = Mapper.class.getResourceAsStream(pathFile);
        if (input != null) {
            properties.load(input);
        } else {
            throw new FileNotFoundException("file not founded");
        }

        for(Field field: User.class.getFields()) {
            MapperCSV mapper = field.getAnnotation(MapperCSV.class);
            if (mapper != null) {

            }
        }
        Field[] annotatedFields = findAnnotatedFields(Class.forName("ua.com.alevel.AppProperties"), MapperCSV.class);
        for (Field field: annotatedFields) {
            if (field.getType() == String.class) {
                field.set(User.class, properties.getProperty("property.string"));
            }
            if (field.getType() == int.class) {
                field.set(User.class, properties.getProperty("property.int"));
            }
            if (field.getType() == long.class) {
                field.set(User.class, properties.getProperty("property.long"));
            }
            if (field.getType() == double.class) {
                field.set(User.class, properties.getProperty("property.double"));
            }
            if (field.getType() == char.class) {
                field.set(User.class, properties.getProperty("property.char"));
            }
            if (field.getType() == boolean.class) {
                field.set(User.class, properties.getProperty("property.boolean"));
            }
        }
    }

}
