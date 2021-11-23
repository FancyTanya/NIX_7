package ua.com.alevel.starteducation.service.impl;

import io.swagger.v3.oas.annotations.Parameter;
import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.com.alevel.starteducation.dto.response.ResponseContainer;
import ua.com.alevel.starteducation.model.Student;
import ua.com.alevel.starteducation.repository.StudentRepository;
import ua.com.alevel.starteducation.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void create(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void update(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public boolean existById(Long id) {
        return studentRepository.existsById(id);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    @PageableAsQueryParam
    public Page<ResponseContainer> findAll(@Parameter(hidden = true) Pageable pageable) {
        return studentRepository.findAll(pageable).map(ResponseContainer::new);
    }

    @Override
    @PageableAsQueryParam
    public Page<ResponseContainer> findAllByTeacher(Long teacherId, @Parameter(hidden = true) Pageable pageable) {
        return studentRepository.findAllByTeacher(teacherId, pageable).map(ResponseContainer::new);
    }
}