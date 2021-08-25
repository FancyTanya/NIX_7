package ua.com.alevel.dao;

import ua.com.alevel.db.ArrayDB;
import ua.com.alevel.entity.Student;

import java.util.UUID;

import static java.util.Arrays.copyOf;

public class StudentDao {
    ArrayDB arrayDB = ArrayDB.getInstance();
    private Student[] students = arrayDB.getStudents();

    private static final StudentDao instance = new StudentDao();

    public static StudentDao getInstance() {
        return instance;
    }

    public String create(Student student) {
        for (Student value: students) {
            if (value != null) {
                if (value.getFullName().equals(student.getFullName())) {
                    student.setId(value.getId());
                    return student.getId();
                }
            }
        }
        student.setId(generateId());
        students = copyOf(students, students.length);
        students[students.length - 1] = student;
        return student.getId();
    }

    public void update(Student student) {
        for (Student value: students) {
            if (value != null) {
                if (value.getFullName().equals(student.getFullName())) {
                    student.setId(student.getId());
                    return;
                }
            }
        }
        Student inDbStudent = findStudentById(student.getId());
        inDbStudent.setLastName(student.getLastName());
    }

    public void delete(String id) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getId().equals(id)) {
                students[i].setNotActive();
            }
        }
    }

    public Student findStudentById(String id) {
        if (students.length > 0) {
            for (Student value: students) {
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

    public Student findIdByFullName(String fullname) {
        for (Student value: students) {
            if (value.getFullName().equals(fullname)) {
                return value;
            }
        }
        return null;
    }

    public Student[] findAllActiveStudents() {
        Student[] activeStudents = new Student[students.length];
        for (int i = 0; i < students.length; i++) {
            if (students[i].isActive()) {
               students[i] = activeStudents[i];
            }
        }
        return activeStudents;
    }

    public String generateId() {
        String id = UUID.randomUUID().toString();
        for (Student student: students) {
            if (student.getId().equals(id)) {
                return generateId();
            }
        }
        return id;
    }
}
