package ua.com.alevel.servise.impl;

import ua.com.alevel.dao.StudentDao;
import ua.com.alevel.entity.Student;
import ua.com.alevel.servise.StudentService;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    @Override
    public void create(Student student) {

    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public Student[] findAll() {
        return new Student[0];
    }
}
