package ua.com.alevel;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Factory<T> {
    public T map(Class<T> type, Properties properties) {
        List<Field> fields = Arrays.asList(type.getDeclaredFields());
        return (T) new Object();
    }
}
