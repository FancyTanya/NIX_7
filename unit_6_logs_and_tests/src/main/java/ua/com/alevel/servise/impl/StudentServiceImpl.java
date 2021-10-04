package main.java.ua.com.alevel.servise.impl;

import main.java.ua.com.alevel.dao.StudentDao;
import main.java.ua.com.alevel.entity.Student;
import main.java.ua.com.alevel.servise.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudentServiceImpl implements StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    private final StudentDao studentDao;

    @Override
    public void create(Student student) {
    logger.info("Create new student "+ student.getFullName());
    Student newStudent = new Student();
    newStudent.setId(student.getId());
    newStudent.setCourse(student.getCourse());
    studentDao.createStudent(student);
    }

    @Override
    public void update(Student student) {
        logger.info("Update student " + student.getFullName());
        Student newStudent = new Student();
        newStudent.setId(student.getId());
        newStudent.setFullName(student.getFullName());
        if (student.getCourse() != null && student.getCourse().length >0) {
            int[] courses = new int[student.getCourse().length];
            for (int i = 0; i < student.getCourse().length; i++) {
                if (student.getCourse()[i] != null) {
                    courses[i] = student.getCourse()[i].getId();
                } else {
                    courses[i] = -1;
                }
            }
            studentDao.updateStudent(newStudent, courses);
        }
    }

    @Override
    public void delete(int id) {
        logger.warn("Student with id "+ id + " is deleting" );
        studentDao.deleteStudentById(id);
    }

    @Override
    public Student findById(int id) {
        Student student = studentDao.getStudentById(id);
        Student newStudent = new Student();
        newStudent.setId(student.getId());
        newStudent.setFullName(student.getFullName());
        return newStudent;
    }



    @Override
    public Student[] findAll() {
        Student[] students = studentDao.getAllStudents();
        return students;
    }
}
