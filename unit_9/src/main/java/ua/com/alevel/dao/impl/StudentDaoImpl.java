package ua.com.alevel.dao.impl;

import main.java.ua.com.alevel.dao.StudentDao;
import main.java.ua.com.alevel.db.StudentCourseDb;
import main.java.ua.com.alevel.db.StudentDb;
import main.java.ua.com.alevel.entity.Student;

public class StudentDaoImpl implements StudentDao {

    private final StudentDb studentDb;
    private final StudentCourseDb studentCourseDb;

    public StudentDaoImpl(StudentDb studentDb, StudentCourseDb studentCourseDb) {
        this.studentDb = studentDb;
        this.studentCourseDb = studentCourseDb;
    }

    @Override
    public Student getStudentById(int id) {
        return studentDb.getStudentByID(id);
    }

    @Override
    public void createStudent(Student student) {
        studentDb.createStudent(student);
    }

    @Override
    public void deleteStudentById(int id) {
        studentDb.deleteStudentById(id);
    }

    @Override
    public void updateStudent(Student student) {
        studentDb.updateStudent(student);
    }

    @Override
    public void updateStudent(Student student, int[] courseListIds) {
        studentDb.updateStudent(student);
        studentCourseDb.updateCoursesListBYStudentId(student.getId(),courseListIds);
    }

    @Override
    public Student[] getStudentListByCourseId(int courseId) {
        int[] studentIdList = studentCourseDb.getStudentIdByCourseId(courseId);
        Student[] students = null;
        if(studentIdList != null) {
            students = new Student[studentIdList.length];
            for (int i = 0; i < studentIdList.length; i++) {
                students[i] = studentDb.getStudentByID(studentIdList[i]);
            }
        }
        return students;
    }

    @Override
    public Student[] getAllStudents() {
        return studentDb.getAllStudents();
    }

}
