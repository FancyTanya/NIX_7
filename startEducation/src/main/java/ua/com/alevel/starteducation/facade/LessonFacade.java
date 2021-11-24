package ua.com.alevel.starteducation.facade;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.com.alevel.starteducation.dto.request.LessonDtoRequest;
import ua.com.alevel.starteducation.dto.response.LessonDtoResponse;
import ua.com.alevel.starteducation.model.Lesson;

import java.util.List;

public interface LessonFacade {

    void create(LessonDtoRequest dto, Long id);

    void update(LessonDtoRequest dto, Long id);

    void delete(Long id);

    LessonDtoResponse findById(Long id);

    Page<Lesson> findAll(Pageable pageable);

    Page<Lesson> findAllByTeacher(Long teacherId, Pageable pageable);
}
