package main.java.ua.com.alevel.dao;

import main.java.ua.com.alevel.entity.Student;

public interface StudentDao {

    Student getStudentById(int id);

    void createStudent(Student student);

    void deleteStudentById(int id);

    void updateStudent(Student student);

    void updateStudent(Student student, int[] courseListIds);

    Student[] getStudentListByCourseId(int courseId);

    Student[] getAllStudents();


}
