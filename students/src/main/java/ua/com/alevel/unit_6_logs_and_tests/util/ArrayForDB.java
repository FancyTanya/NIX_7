package ua.com.alevel.unit_6_logs_and_tests.util;


public class ArrayForDB<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private int SIZE = 10;
    private Object[] array = new Object[SIZE];
    private int HEAD = 0;
    private final int MULTIPLIER = 2;

    public boolean add(T t) {
        if (HEAD == array.length - 1) {
            resize(array.length * MULTIPLIER);
        }
        array[HEAD++] = t;
        return true;
    }

    private void resize(int newSize) {
        Object[] newArray = new Object[newSize];
        System.arraycopy(array, 0, newArray, 0, HEAD);
        array = newArray;
    }

    public T get(int index) {
        return (T) array[index];
    }

    public boolean isEmpty() {
        if (HEAD == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getSize() {
        return HEAD;
    }
    public  boolean containsOf(Object[] objects, Object o ) {
      return indexOf(objects, o) >= 0;
    }

    private boolean indexOf(Object[] newArray, Object o) {
        for (Object objects: newArray) {
            if (objects == o) {
                return true;
            }
        }
        return false;
    }

}
