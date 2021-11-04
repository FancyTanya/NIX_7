package ua.com.alevel.starteducation.facade;

import ua.com.alevel.starteducation.dto.request.StudentDtoRequest;
import ua.com.alevel.starteducation.dto.response.StudentDtoResponse;

import java.util.List;

public interface StudentFacade {

    void create(StudentDtoRequest dto);
    void update(StudentDtoRequest dto, Long id);
    void delete(Long id);
    StudentDtoResponse findById(Long id);
    List<StudentDtoResponse> findAll();
    List<StudentDtoResponse> findAllByTeacher(Long teacherId);

}
