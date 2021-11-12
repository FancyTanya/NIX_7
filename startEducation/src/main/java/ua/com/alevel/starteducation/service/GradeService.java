package ua.com.alevel.starteducation.service;

import ua.com.alevel.starteducation.model.Grade;

import java.util.List;

public interface GradeService extends CrudService<Grade>{
    List<Grade> findAllByStudent(Long studentId);
}
