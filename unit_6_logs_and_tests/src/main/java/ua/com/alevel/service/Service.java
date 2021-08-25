package ua.com.alevel.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.com.alevel.dao.CourseDao;
import ua.com.alevel.dao.GroupOfStudentsDao;
import ua.com.alevel.dao.StudentDao;
import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.GroupOfStudents;
import ua.com.alevel.entity.Student;

public class Service {
    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");

    private final StudentDao studentDao = StudentDao.getInstance();
    private final CourseDao courseDao = CourseDao.getInstance();
    private final GroupOfStudentsDao groupOfStudentsDao = GroupOfStudentsDao.getInstance();
    private final static Service instance = new Service();

    public static Service getInstance() {
        return instance;
    }

    public void createGroupOfStudents(String course, Student[] students) {
        LOGGER_INFO.info("Create new group of students for course " + course);
        if (students[0].getFullName().equals("")) {
            return;
        }
        if (course.equals("")) {
            return;
        }
        for (Student value : students) {
            groupOfStudentsDao.create(CourseDao.getInstance().findCourseById(course).getId(), students);
        }
    }

    public void update(GroupOfStudents group) {
        LOGGER_INFO.info("Update group of students " + group.getGroup());
        groupOfStudentsDao.update(group);
    }

    public void delete(String id) {
        LOGGER_WARN.warn("Object with id " + id + "deleting");
        studentDao.delete(id);
        courseDao.delete(id);
    }

    public Student findStudentById(String studentId) {
        return studentDao.findStudentById(studentId);
    }

    public Course findCourseById(String courseId) {
        return courseDao.findCourseById(courseId);
    }

    public Student findStudentByFullName(String fullname) {
        return studentDao.findIdByFullName(fullname);
    }

    public Student[] findAllActiveStudents() {
        return studentDao.findAllActiveStudents();
    }

    public Course[] findAllActiveCourses() {
        return courseDao.findAllActiveCourses();
    }

    public GroupOfStudents[] findAllActiveGroups() {
        return groupOfStudentsDao.findAllActiveGroups();
    }

    public Course findIdByFullTitle(String title) {
        for (Course value: courseDao.findAllActiveCourses()) {
            if (value.getTitle().equals(title)) {
                return value;
            }
        }
        return null;
    }
}
