package ua.com.alevel.dao.impl;

import ua.com.alevel.dao.CourseDao;
import ua.com.alevel.entity.Course;

public class CourseDaoImpl implements CourseDao {
    @Override
    public Course getCourseById(int id) {
        return null;
    }

    @Override
    public void createCourse(Course course) {

    }

    @Override
    public void deleteCourseById(int id) {

    }

    @Override
    public void updateCourse(Course course) {

    }

    @Override
    public void updateCourse(Course course, int[] studentListIds) {

    }

    @Override
    public Course[] getCoursesListByStudentId(int studentId) {
        return new Course[0];
    }

    @Override
    public Course[] getAllCourses() {
        return new Course[0];
    }
}
