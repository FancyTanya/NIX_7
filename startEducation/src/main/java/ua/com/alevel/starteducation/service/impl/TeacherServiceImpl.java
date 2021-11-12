package ua.com.alevel.starteducation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.alevel.starteducation.model.Teacher;
import ua.com.alevel.starteducation.repository.TeacherRepository;
import ua.com.alevel.starteducation.service.TeacherService;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void create(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public void update(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public void delete(Long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public boolean existById(Long id) {
        return teacherRepository.existsById(id);
    }

    @Override
    public Teacher findById(Long id) {
       return teacherRepository.findById(id).get();
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }
}
