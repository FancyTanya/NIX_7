package ua.com.alevel.entity;

import ua.com.alevel.annotation.MapperCSV;

public class Employee {
    @MapperCSV("name")
    String name;
    @MapperCSV("age")
    int age;
    @MapperCSV("department")
    String department;
    @MapperCSV("salary")
    double salary;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
