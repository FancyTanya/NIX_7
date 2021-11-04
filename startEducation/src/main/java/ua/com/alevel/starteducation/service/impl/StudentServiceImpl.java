package ua.com.alevel.starteducation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Student findById(Long id) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        return null;
    }
}
