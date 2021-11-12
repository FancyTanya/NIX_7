package ua.com.alevel.starteducation.facade.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.starteducation.dto.request.StudentDtoRequest;
import ua.com.alevel.starteducation.dto.response.StudentDtoResponse;
import ua.com.alevel.starteducation.facade.StudentFacade;
import ua.com.alevel.starteducation.model.Student;
import ua.com.alevel.starteducation.service.StudentService;
import ua.com.alevel.starteducation.service.TeacherService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentFacadeImpl implements StudentFacade {

    private final StudentService studentService;
    private final TeacherService teacherService;

    public StudentFacadeImpl(StudentService studentService, TeacherService teacherService) {
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    @Override
    public void create(StudentDtoRequest dto) {
        Student student = new Student();
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        studentService.create(student);
    }

    @Override
    public void update(StudentDtoRequest dto, Long id) {
        Student student = studentService.findById(id);
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        studentService.update(student);
    }

    @Override
    public void delete(Long id) {
        if (studentService.existById(id)) {
            studentService.delete(id);
        }
    }

    @Override
    public StudentDtoResponse findById(Long id) {
        return new StudentDtoResponse(studentService.findById(id));
    }

    @Override
    public List<StudentDtoResponse> findAll() {
        return studentService.findAll().stream().map(StudentDtoResponse::new).collect(Collectors.toList());
    }

    @Override
    public List<StudentDtoResponse> findAllByTeacher(Long teacherId) {
        return studentService.findAllByTeacher(teacherId).stream().map(StudentDtoResponse::new).collect(Collectors.toList());
    }
}
