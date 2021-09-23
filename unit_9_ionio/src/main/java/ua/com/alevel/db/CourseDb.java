package ua.com.alevel.db;

import lombok.NoArgsConstructor;
import ua.com.alevel.entity.Course;

import java.util.UUID;

@NoArgsConstructor
public class CourseDb {

    private static CourseDb instance;
    private Course[] courseDb = new Course[10];
    private int index = 0;
    private final int MULTIPLIER = 2;

    public static CourseDb getInstance() {
        if (instance == null) {
            instance = new CourseDb();
        }
        return instance;
    }

    public void createCourse(Course course) {
        if (courseDb[courseDb.length - 1] != null) {
            increaseArray();
        }
        course.setId();
        courseDb[index] = course;
        index++;
    }

    public void updateCourse(Course course) {
        int courseIndex = getIndexByID(course.getId());
        courseDb[courseIndex].setName(course.getName());
    }

    public Course getCourseById(int id) {
        return courseDb[getIndexByID(id)];
    }

    public Course[] getAllCourses() {
        return courseDb;
    }

    public void deleteCourseById(int id) {
        courseDb[getIndexByID(id)] = null;
        rebuildArray(courseDb.length);
    }

    private int getIndexByID(int id) {
        for (int i = 0; i < courseDb.length; i++) {
            if(courseDb[i] != null && courseDb[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    private void increaseArray() {
        int newLength = courseDb.length*MULTIPLIER;
        rebuildArray(newLength);
    }

    private void rebuildArray(int length) {
        Course[] newCourseDb = new Course[length];
        int indexCount = 0;
        for (int i = 0; i < courseDb.length; i++) {
            if (courseDb[i] != null) {
                newCourseDb[indexCount] =courseDb[i];
                indexCount++;
            }
        }
        courseDb = newCourseDb;
        index = indexCount;
    }

}
