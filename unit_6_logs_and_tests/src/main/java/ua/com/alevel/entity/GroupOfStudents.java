package ua.com.alevel.entity;

import java.util.Arrays;

public class GroupOfStudents {
    private String idStudent;
    private String idCourse;
    private boolean isActive = true;
    private Student[] students;
    private GroupOfStudents group;

    @Override
    public String toString() {
        return "GroupOfStudents{" +
                "students=" + Arrays.toString(students) +
                ", group=" + group +
                '}';
    }

    public GroupOfStudents getGroup() {
        return group;
    }

    public void setGroup(GroupOfStudents group) {
        this.group = group;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setIsNotActive() {
        isActive = false;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }

    public void addStudentsToGroup(Student[] students) {
        group.setStudents(students);
    }

    public int countOfStudents(Student[] students) {
        return students.length;
    }
}
