package ua.com.alevel.controller;

import ua.com.alevel.dto.request.CourseDtoRequest;
import ua.com.alevel.dto.response.CourseDtoResponse;
import ua.com.alevel.facade.CourseFacade;
import ua.com.alevel.facade.StudentFacade;

public class CourseController {

    private final StudentFacade studentFacade;
    private final CourseFacade courseFacade;

    public CourseController(StudentFacade studentFacade, CourseFacade courseFacade) {
        this.studentFacade = studentFacade;
        this.courseFacade = courseFacade;
    }

    private CourseDtoResponse update(CourseDtoRequest dto, int id) {
        courseFacade.update(dto,id);
        return ;
    }

    private CourseDtoRequest findById(int id) {
        courseFacade.findById(id);
        return null;
    }

}
