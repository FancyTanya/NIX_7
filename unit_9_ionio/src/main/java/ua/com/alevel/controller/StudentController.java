package ua.com.alevel.controller;

import ua.com.alevel.dto.request.StudentDtoRequest;
import ua.com.alevel.dto.response.StudentDtoResponse;
import ua.com.alevel.facade.CourseFacade;
import ua.com.alevel.facade.StudentFacade;

public class StudentController {
    private final StudentFacade studentFacade;
    private final CourseFacade courseFacade;

    public StudentController(StudentFacade studentFacade, CourseFacade courseFacade) {
        this.studentFacade = studentFacade;
        this.courseFacade = courseFacade;
    }

    private StudentDtoResponse create(StudentDtoRequest dto, int courseId) {
        studentFacade.create(dto, courseId);
        return null;
    }

    private StudentDtoResponse update(StudentDtoRequest dto, int courseId) {
        studentFacade.update(dto, courseId);
        return null;
    }

    private StudentDtoResponse delete(int id) {
        studentFacade.delete(id);
        return null;
    }

    private StudentDtoResponse findById(int id) {
        studentFacade.findById(id);
        return null;
    }

    private StudentDtoResponse[] findAll() {
        studentFacade.findAll();
        return null;
    }

    private StudentDtoResponse[] findAllByCourse(int courseId) {
        studentFacade.findByCourse(courseId);
        return null;
    }
}
