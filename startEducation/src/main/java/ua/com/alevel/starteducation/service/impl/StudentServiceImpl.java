package ua.com.alevel.starteducation.service.impl;

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
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findAllByTeacher(Long teacherId) {
        return studentRepository.findAllByTeacher(teacherId);
    }
}
