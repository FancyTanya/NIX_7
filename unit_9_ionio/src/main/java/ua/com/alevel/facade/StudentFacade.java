package ua.com.alevel.facade;

import ua.com.alevel.dto.request.StudentDtoRequest;
import ua.com.alevel.dto.response.StudentDtoResponse;
import ua.com.alevel.entity.Student;

public interface StudentFacade {
    void create(StudentDtoRequest dto, int courseId);
    void update(StudentDtoRequest dto, int courseId);
    void delete(int id);
    StudentDtoResponse findById(int id);
    StudentDtoResponse[] findAll();
    StudentDtoResponse[] findByCourse(int courseId);
}
