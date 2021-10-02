package ua.com.alevel.entity;

import ua.com.alevel.annotation.MapperCSV;

public class User {
    @MapperCSV("name")
    String name;
    @MapperCSV("age")
    int age;
    @MapperCSV("department")
    String department;
    @MapperCSV("salary")
    double salary;
}
