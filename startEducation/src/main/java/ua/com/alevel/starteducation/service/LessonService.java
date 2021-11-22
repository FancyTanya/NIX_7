package ua.com.alevel.starteducation.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.com.alevel.starteducation.dto.response.ResponseContainer;
import ua.com.alevel.starteducation.model.Lesson;

import java.util.List;

public interface LessonService extends CrudService<Lesson>{
    Page<ResponseContainer> findAllByTeacher(Long teacherId, Pageable pageable);
}
