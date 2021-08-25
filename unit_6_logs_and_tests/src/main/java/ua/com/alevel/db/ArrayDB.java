package ua.com.alevel.db;

import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.GroupOfStudents;
import ua.com.alevel.entity.Student;

public class ArrayDB {

    private static final ArrayDB instance = new ArrayDB();
    private Student[] students;
    private Course[] courses;

    public Student[] getStudents() {
        return students;
    }

    private ArrayDB() {

    }

    public static ArrayDB getInstance() {
        return instance;
    }

    private GroupOfStudents[] groupOfStudents = new GroupOfStudents[1];

    public GroupOfStudents[] getGroupOfStudents() {
        return groupOfStudents;
    }

    public Course[] getCourse() {
        return courses;
    }
}
