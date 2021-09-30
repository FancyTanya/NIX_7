package ua.com.alevel.dto.response;

import ua.com.alevel.db.CourseDb;

public class CourseDtoResponse {


    ua.com.alevel.db.CourseDb courseDb = new CourseDb();

    public CourseDb create(int courseId) {
        courseDb.getCourseById(courseId);
        return courseDb;
    }

    public CourseDb update(int courseId) {
        courseDb.updateCourse(courseDb.getCourseById(courseId));
        return courseDb;
    }

    public boolean delete(int courseId) {
        if (courseDb.getCourseById(courseId) != null) {
            courseDb.deleteCourseById(courseId);
            return true;
        }
        return false;
    }


}
