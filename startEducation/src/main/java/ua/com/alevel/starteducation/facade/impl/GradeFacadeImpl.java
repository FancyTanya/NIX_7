package ua.com.alevel.starteducation.facade.impl;

import ua.com.alevel.starteducation.dto.request.GradeDtoRequest;
import ua.com.alevel.starteducation.dto.response.GradeDtoResponse;
import ua.com.alevel.starteducation.facade.GradeFacade;
import ua.com.alevel.starteducation.model.Grade;
import ua.com.alevel.starteducation.model.Student;
import ua.com.alevel.starteducation.service.GradeService;
import ua.com.alevel.starteducation.service.StudentService;

import java.util.List;
import java.util.stream.Collectors;

public class GradeFacadeImpl implements GradeFacade {

    private final GradeService gradeService;
    private final StudentService studentService;

    public GradeFacadeImpl(GradeService gradeService, StudentService studentService) {
        this.gradeService = gradeService;
        this.studentService = studentService;
    }

    @Override
    public void create(GradeDtoRequest dto, Long studentId) {
        Grade grade = new Grade();
        grade.setGrade(dto.getGrade());
        Student student = studentService.findById(studentId);
        grade.setStudent(student);
        gradeService.create(grade);
    }

    @Override
    public void update(GradeDtoRequest dto, Long id) {
        Grade grade = gradeService.findById(id);
        grade.setGrade(dto.getGrade());
        gradeService.update(grade);

    }

    @Override
    public void delete(Long id) {
        if (gradeService.existById(id)) {
            gradeService.delete(id);
        }
    }

    @Override
    public GradeDtoResponse findById(Long id) {
        return new GradeDtoResponse(gradeService.findById(id));
    }

    @Override
    public List<GradeDtoResponse> findAll() {
        return gradeService.findAll().stream().map(GradeDtoResponse::new).collect(Collectors.toList());
    }

    @Override
    public List<GradeDtoResponse> findAllByStudent(Long studentId) {
        return gradeService.findAllByStudent(studentId).stream().map(GradeDtoResponse::new).collect(Collectors.toList());
    }
}
