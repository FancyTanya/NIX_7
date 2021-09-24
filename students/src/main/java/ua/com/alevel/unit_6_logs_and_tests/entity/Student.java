package ua.com.alevel.unit_6_logs_and_tests.entity;

public class Student {
    private String id;
    private String name;
    private String surname;
    private String course;
    private int grade;

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    Student[] students;

    public String getId() {
        return id;
    }

    public void setId(final String id) {

        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Student[] findAll () {
        return students;
    }

}