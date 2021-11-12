package ua.com.alevel.starteducation.facade;

import ua.com.alevel.starteducation.dto.request.LessonDtoRequest;
import ua.com.alevel.starteducation.dto.response.LessonDtoResponse;

import java.util.List;

public interface LessonFacade {

    void create(LessonDtoRequest dto, Long id);

    void update(LessonDtoRequest dto, Long id);

    void delete(Long id);

    LessonDtoResponse findById(Long id);

    List<LessonDtoResponse> findAll();

    List<LessonDtoResponse> findAllByTeacher(Long teacherId);
}
