package ua.com.alevel.dao;

import ua.com.alevel.db.ArrayDB;
import ua.com.alevel.entity.Course;

import java.util.UUID;

import static java.util.Arrays.copyOf;

public class CourseDao {

    ArrayDB arrayDB = ArrayDB.getInstance();
    private Course[] courses = arrayDB.getCourse();

    private static final CourseDao instance = new CourseDao();

    public static CourseDao getInstance() {
        return instance;
    }

    public String create(Course course) {
        for (Course value: courses) {
            if (value != null) {
                if (value.getTitle().equals(course.getTitle())) {
                    course.setId(value.getId());
                    return course.getId();
                }
            }
        }
        course.setId(generateId());
        courses = copyOf(courses, courses.length);
        courses[courses.length - 1] = course;
        return course.getId();
    }

    public void update(Course course) {
        for (Course value: courses) {
            if (value != null) {
                if (value.getTitle().equals(course.getTitle())) {
                    course.setId(course.getId());
                    return;
                }
            }
        }
        Course inDbCourse = findCourseById(course.getId());
        inDbCourse.setTitle(course.getTitle());
    }


    public void delete(String id) {
        for (int i = 0; i < courses.length; i++) {
            if (courses[i].getId().equals(id)) {
                courses[i].isNotActive();
            }
        }
    }

    public Course findCourseById(String id) throws NullPointerException{
        if (courses.length > 0) {
            for (Course value: courses) {
                if (value == null) {
                    break;
                }
                if (value.getId().equals(id)) {
                    return value;
                }
            }
        }
        return null;
    }

    public Course findIdByFullTitle(String title) {
        for (Course value: courses) {
            if (value.getTitle().equals(title)) {
                return value;
            }
        }
        return null;
    }

    public Course[] findAllActiveCourses() {
        Course[] activeCourses = new Course[courses.length];
        for (int i = 0; i < courses.length; i++) {
            if (courses[i].isActive()) {
                courses[i] = activeCourses[i];
            }
        }
        return activeCourses;
    }

    public String generateId() {
        String id = UUID.randomUUID().toString();
        for (Course course: courses) {
            if (course.getId().equals(id)) {
                return generateId();
            }
        }
        return id;
    }
}
