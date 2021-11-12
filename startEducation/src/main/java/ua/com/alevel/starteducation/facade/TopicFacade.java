package ua.com.alevel.starteducation.facade;

import ua.com.alevel.starteducation.dto.request.LessonDtoRequest;
import ua.com.alevel.starteducation.dto.request.TopicDtoRequest;
import ua.com.alevel.starteducation.dto.response.LessonDtoResponse;
import ua.com.alevel.starteducation.dto.response.TopicDtoResponse;
import ua.com.alevel.starteducation.model.Topic;

import java.util.List;

public interface TopicFacade {

    void create(TopicDtoRequest dto, Long id);

    void update(TopicDtoRequest dto, Long id);

    void delete(Long id);

    TopicDtoResponse findById(Long id);

    List<TopicDtoResponse> findAll();

    List<TopicDtoResponse> findAllByTeacher(Long teacherId);
}
