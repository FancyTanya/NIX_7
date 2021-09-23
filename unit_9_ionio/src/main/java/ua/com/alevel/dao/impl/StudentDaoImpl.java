package ua.com.alevel.dao.impl;

import ua.com.alevel.dao.StudentDao;
import ua.com.alevel.entity.Student;

public class StudentDaoImpl implements StudentDao {
    @Override
    public Student getStudentById(int id) {
        return null;
    }

    @Override
    public void createStudent(Student student) {

    }

    @Override
    public void deleteStudentById(int id) {

    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void updateStudent(Student student, int[] courseListIds) {

    }

    @Override
    public Student[] getStudentListByCourseId(int courseId) {
        return new Student[0];
    }

    @Override
    public Student[] getAllStudents() {
        return new Student[0];
    }
}
