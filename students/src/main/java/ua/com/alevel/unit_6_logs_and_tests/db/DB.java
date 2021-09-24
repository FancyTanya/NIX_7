package ua.com.alevel.unit_6_logs_and_tests.db;


import ua.com.alevel.unit_6_logs_and_tests.entity.Student;
import ua.com.alevel.unit_6_logs_and_tests.util.ArrayForDB;

import java.util.UUID;

public class DB {
    private static DB instance;
    private final ArrayForDB<Student> students = new ArrayForDB<>();

    private DB() {}

    public static DB getInstance() {
        if (instance == null) {
            instance = new DB();
        }
        return instance;
    }
    private String generateId() {
        String id  = UUID.randomUUID().toString();
        if (students.containsOf(id)) {
            generateId();
        }
    }



}
