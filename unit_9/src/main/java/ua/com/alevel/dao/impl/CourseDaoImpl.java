package ua.com.alevel.dao.impl;

import main.java.ua.com.alevel.dao.CourseDao;
import main.java.ua.com.alevel.db.CourseDb;
import main.java.ua.com.alevel.db.StudentCourseDb;
import main.java.ua.com.alevel.entity.Course;

public class CourseDaoImpl implements CourseDao {
    private final CourseDb courseDb;
    private final StudentCourseDb studentCourseDb;

    public CourseDaoImpl(CourseDb courseDb, StudentCourseDb studentCourseDb) {
        this.courseDb = courseDb;
        this.studentCourseDb = studentCourseDb;
    }

    @Override
    public Course getCourseById(int id) {
        return courseDb.getCourseById(id);
    }

    @Override
    public void createCourse(Course course) {
        courseDb.createCourse(course);
    }

    @Override
    public void deleteCourseById(int id) {
        courseDb.deleteCourseById(id);
    }

    @Override
    public void updateCourse(Course course) {
        courseDb.updateCourse(course);
    }

    @Override
    public void updateCourse(Course course, int[] studentListIds) {
        courseDb.updateCourse(course);
        studentCourseDb.updateStudentsListByCourseId(course.getId(), studentListIds);
    }

    @Override
    public Course[] getCoursesListByStudentId(int studentId) {
        int[] courseIdList = studentCourseDb.getCourseIdByStudentId(studentId);
        Course[] courses = null;
        if (courseIdList != null) {
            courses = new Course[courseIdList.length];
            for (int i = 0; i < courseIdList.length; i++) {
                courses[i] = courseDb.getCourseById(courseIdList[i]);
            }
        }
        return courses;
    }

    @Override
    public Course[] getAllCourses() {
        return courseDb.getAllCourses();
    }
}
