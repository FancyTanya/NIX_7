package ua.com.alevel.entity;

public class Student extends BaseType{

    private String firsName;
    private String lastName;
    Course course;

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

    public void setFullName(String fullName) {
        fullName = firsName + " " + lastName;
    }

    public String getFullName() {
        return firsName + " " + lastName;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
