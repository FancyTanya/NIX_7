package ua.com.alevel.starteducation.service;

import ua.com.alevel.starteducation.model.BaseEntity;

import java.util.List;

public interface CrudService<E extends BaseEntity> {

    void create(E e);
    void update(E e);
    void delete(Long id);
    boolean existById(Long id);
    E findById(Long id);
    List<E> findAll();

}
