package ua.com.alevel.servise;

import main.java.ua.com.alevel.entity.BaseType;

public interface CrudService <E extends BaseType> {
    void create(E e);
    void update(E e);
    void  delete(int id);
    E findById(int id);
    E[] findAll();
}
