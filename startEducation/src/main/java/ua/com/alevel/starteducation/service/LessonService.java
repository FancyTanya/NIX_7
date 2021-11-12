package ua.com.alevel.starteducation.service;

import ua.com.alevel.starteducation.model.Lesson;

import java.util.List;

public interface LessonService extends CrudService<Lesson>{
    List<Lesson> findAllByTeacher(Long teacherId);
}
