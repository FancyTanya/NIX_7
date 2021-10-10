package ua.com.alevel.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.entity.Table;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapperCSV {
    private final static Logger logger = LoggerFactory.getLogger(MapperCSV.class);

    public<T> List<T> getObject(Class<T> clazz,Table table) {
        List<String> header = table.getHeader();
        List<String> rows = table.getRows();
        List<T> list = new ArrayList<>();
        Map<String,Integer> fieldNames = getMapFieldNames(header);
        for (String row: rows) {
            list.add(getObjectFromString(clazz, row, fieldNames));
        }
        return list;
    }

    private static Map<String,Integer> getMapFieldNames(List<String> fieldNames) {
        Map<String, Integer> mapNames = new HashMap<>();
        for (int i = 0; i < fieldNames.size(); i++) {
            mapNames.put(fieldNames.get(i), i);
        }
        return mapNames;
    }

    private <T> T getObjectFromString(Class<T> clazz, String csvString, Map<String ,Integer> fieldNames) {
        Field[] fields = clazz.getDeclaredFields();
        T t = null;
        String[] values = csvString.split(",");

        try {
            t = clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            logger.warn(e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            logger.warn(e.getMessage());
        } catch (NoSuchMethodException e) {
            logger.warn(e.getMessage());
        }
        for (Field field:fields) {
            int index = fieldNames.get(field.getName());
            String value = values[index].trim();
                if (field.getType() == String.class) {
                    try {
                        field.set(t, value);
                    } catch (IllegalAccessException e) {
                        logger.warn(e.getMessage());
                    }
                }
                if (field.getType() == int.class) {
                    try {
                        field.setInt(t, Integer.parseInt(value));
                    } catch (IllegalAccessException e) {
                        logger.warn(e.getMessage());
                    }
                }
                if (field.getType() == double.class) {
                    try {
                        field.setDouble(t, Double.parseDouble(value));
                    } catch (IllegalAccessException e) {
                        logger.warn(e.getMessage());
                    }
                }
                if (field.getType() == float.class) {
                    try {
                        field.setFloat(t, Float.parseFloat(value));
                    } catch (IllegalAccessException e) {
                        logger.warn(e.getMessage());
                    }
                }
                if (field.getType() == char.class) {
                    try {
                        field.setChar(t, value.charAt(0));
                    } catch (IllegalAccessException e) {
                        logger.warn(e.getMessage());
                    }
                }
                if (field.getType() == boolean.class) {
                    try {
                        field.setBoolean(t, Boolean.parseBoolean(value));
                    } catch (IllegalAccessException e) {
                        logger.warn(e.getMessage());
                    }
                }

            }
        return t;
    }
}
