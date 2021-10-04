package main.java.ua.com.alevel.db;

import main.java.ua.com.alevel.entity.Student;

public class StudentDb {

    private static StudentDb instance;
    private Student[] studentDb = new Student[10];
    private int index = 0;
    private final int MULTIPLIER = 2;

    private StudentDb() {}

    public static StudentDb getInstance() {
        if (instance == null) {
            instance = new StudentDb();
        }
        return instance;
    }

    public void createStudent(Student student) {
        if (studentDb[studentDb.length - 1] != null) {
            increaseArray();
        }
        student.getId();
        studentDb[index] =student;
        index++;
    }

    public void updateStudent(Student student) {
        int studentIndex = getIndexByID(student.getId());
        studentDb[studentIndex].setFullName(student.getFullName());
    }

    public Student getStudentByID(int id) {
        int studentIndex = getIndexByID(id);
        return studentDb[studentIndex];
    }

    public Student[] getAllStudents() {
        return studentDb;
    }

    public void deleteStudentById(int id) {
        int studentIndex = getIndexByID(id);
        studentDb[studentIndex] = null;
        rebuildArray(studentDb.length);
    }

    private int getIndexByID(int id) {
        for (int i = 0; i < studentDb.length; i++) {
            if (studentDb[i] != null && studentDb[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    private void increaseArray() {
        int newLength = studentDb.length * MULTIPLIER;
        rebuildArray(newLength);
    }

    private void rebuildArray(int length) {
        Student[] newStudents =new Student[length];
        int indexCount = 0;
        for (int i = 0; i < studentDb.length; i++) {
            if (studentDb[i] != null) {
                newStudents[indexCount] =studentDb[i];
                indexCount++;
            }
        }
        studentDb = newStudents;
        index = indexCount;
    }

}
