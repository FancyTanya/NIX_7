package ua.com.alevel.starteducation.facade;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    Page<Topic> findAll(Pageable pageable);

    Page<Topic> findAllByTeacher(Long teacherId, Pageable pageable);
}
