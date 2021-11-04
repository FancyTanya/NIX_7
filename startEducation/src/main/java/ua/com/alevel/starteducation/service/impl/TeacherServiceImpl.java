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

    }

    @Override
    public void update(Teacher teacher) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Teacher findById(Long id) {
        return null;
    }

    @Override
    public List<Teacher> findAll() {
        return null;
    }
}
