package ua.com.alevel.dao;

import main.java.ua.com.alevel.entity.Course;

public interface CourseDao {

    Course getCourseById(int id);

    void createCourse(Course course);

    void deleteCourseById(int id);

    void updateCourse(Course course);

    void updateCourse(Course course, int[] studentListIds);

    Course[] getCoursesListByStudentId(int studentId);

    Course[] getAllCourses();
}
