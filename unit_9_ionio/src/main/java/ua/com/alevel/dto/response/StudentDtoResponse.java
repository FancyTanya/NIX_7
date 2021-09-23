package ua.com.alevel.dto.response;

import ua.com.alevel.entity.Student;

public class StudentDtoResponse {
    private int id;
    private String firsName;
    private String lastName;
    private int courseId;
    private String courseName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCoursetId(int coursetId) {
        this.courseId = coursetId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    StudentDtoResponse() {}

    StudentDtoResponse(Student student) {
        this.id = student.getId();
        this.firsName = student.getFirsName();
        this.lastName = student.getLastName();
        if (student.getCourse() != null) {
            this.courseId = student.getCourse().getId();
            this.courseName = student.getCourse().getName();
        }

    }
}
