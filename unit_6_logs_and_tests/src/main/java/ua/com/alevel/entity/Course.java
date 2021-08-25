package ua.com.alevel.entity;

public class Course {
    private String title;
    private String id;
    private boolean isActive;

    public static void setTitle() {
    }

    public boolean isNotActive() {
        return false;
    }
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    private Student[] students;
}
