package main.java.ua.com.alevel.servise.impl;

import main.java.ua.com.alevel.dao.CourseDao;
import main.java.ua.com.alevel.entity.Course;
import main.java.ua.com.alevel.servise.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CourseServiceImpl implements CourseService {

    private final static Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);
    private final CourseDao courseDao;
    private final Course course;

    public CourseServiceImpl(CourseDao courseDao, Course course) {
        this.courseDao = courseDao;
        this.course = course;
    }

    @Override
    public void create(Course course) {
        logger.info("Create new course: title " + course.getName());
        Course newCourse = new Course();
        newCourse.setId(course.getId());
        newCourse.setName(course.getName());
        courseDao.createCourse(course);
    }

    @Override
    public void update(Course course) {
        logger.info("Update course " + course.getId() + " ," + course.getName());
        Course newCourse = new Course();
        newCourse.setId(course.getId());
        newCourse.setName(course.getName());
        if (course.getStudents() != null) {
            int[] students = new int[course.getStudents().length];
            for (int i = 0; i < course.getStudents().length; i++) {
                students[i] = course.getStudents()[i].getId();
            }
            courseDao.updateCourse(course, students);
        }
    }

    @Override
    public void delete(int id) {
        logger.warn("Course " + course.getId() + " ," + course.getName() + " is deleting");
        courseDao.deleteCourseById(id);
    }

    @Override
    public Course findById(int id) {
        Course course = courseDao.getCourseById(id);
        course.setId(id);
        course.setName(course.getName());
        return course;
    }

    @Override
    public Course[] findAll() {
        Course[] courses = courseDao.getAllCourses();
        return courses;
    }
}
