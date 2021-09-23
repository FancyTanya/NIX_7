package ua.com.alevel.servise.impl;

import ua.com.alevel.dao.CourseDao;
import ua.com.alevel.entity.Course;
import ua.com.alevel.servise.CourseService;

public class CourseServiceImpl implements CourseService {

    private CourseDao courseDao;

    @Override
    public void create(Course course) {

    }

    @Override
    public void update(Course course) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Course findById(int id) {
        return null;
    }

    @Override
    public Course[] findAll() {
        return new Course[0];
    }
}
