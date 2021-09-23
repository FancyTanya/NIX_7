package ua.com.alevel.facade;

import ua.com.alevel.dto.request.CourseDtoRequest;
import ua.com.alevel.dto.request.StudentDtoRequest;
import ua.com.alevel.dto.response.StudentDtoResponse;

public interface CourseFacade {
    void create(CourseDtoRequest dto, int idd);
    void update(CourseDtoRequest dto, int id);
    void delete(int id);
    CourseFacade findById(int id);
    CourseFacade[] findAll();
    CourseFacade[] findByCourse(int courseId);
}
