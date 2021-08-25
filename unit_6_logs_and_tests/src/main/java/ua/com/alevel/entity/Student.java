package ua.com.alevel.entity;

public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private boolean isActive = true;
    private Student[] students;

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setNotActive() {
        isActive = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", course=" + course +
                '}';
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Course getCourse() {
        return course;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    private Course course;

}
