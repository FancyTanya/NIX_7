package ua.com.alevel.starteducation.service;

import ua.com.alevel.starteducation.model.Student;
import ua.com.alevel.starteducation.model.Teacher;

import java.util.List;

public interface StudentService extends CrudService<Student> {
    List<Student> findAllByTeacher(Long teacherId);

}
