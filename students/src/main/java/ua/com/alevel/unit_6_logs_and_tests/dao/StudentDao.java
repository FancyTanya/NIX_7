package ua.com.alevel.unit_6_logs_and_tests.dao;

import ua.com.alevel.unit_6_logs_and_tests.entity.Student;
import ua.com.alevel.unit_6_logs_and_tests.util.ArrayForDB;

public interface StudentDao {
    static StudentDao getInstance() {
    }

    void create(Student student);

    void update(Student student);

    void delete(String id);

    Student findById(String id);

    ArrayForDB<Student> findAll();

    void addToCourse();
}
