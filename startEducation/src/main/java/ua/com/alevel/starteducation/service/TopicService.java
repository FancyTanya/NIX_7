package ua.com.alevel.starteducation.service;

import ua.com.alevel.starteducation.model.Topic;

import java.util.List;

public interface TopicService extends CrudService<Topic>{
    List<Topic> findAllByTeacher(Long teacherId);
}
