package ua.com.alevel.service;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.GroupOfStudents;
import ua.com.alevel.entity.Student;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {
    public static final Service service = Service.getInstance();
    public static Course course = new Course();
    private final static int STUDENTS_SIZE = 10;

    @BeforeAll
    static void setup() {
        for (int i = 0; i < STUDENTS_SIZE; i++) {
            Student student1 = new Student();
            student1.setFirstName("first" + i);
            student1.setLastName("last" + i);
            Student student2 = new Student();
            student2.setFirstName("first" + i);
            student2.setLastName("last" + i);
            String course = "Course";
            student1.setCourse(service.findIdByFullTitle(course));
            student2.setCourse(service.findIdByFullTitle(course));
            student1.isActive();
            student2.isActive();
            Student[] students = {student1, student2};
            service.createGroupOfStudents(course, students);

        }
        Assertions.assertEquals(STUDENTS_SIZE, service.findAllActiveStudents().length);
    }


    @Test
    void createGroupOfStudents() {
        Student studentOne = new Student();
        studentOne.setFirstName("One");
        studentOne.setLastName("First");
        Student studentTwo = new Student();
        studentTwo.setFirstName("Two");
        studentTwo.setLastName("Second");
        Student[] students = {studentOne, studentTwo};
        GroupOfStudents group = new GroupOfStudents();
        group.addStudentsToGroup(students);
        Assertions.assertEquals(group.getStudents().length, service.findAllActiveStudents().length);

    }

    @Test
    void update() {
    }

    @Test
    void delete() {
        Student[] students = service.findAllActiveStudents();
        Assertions.assertEquals(STUDENTS_SIZE + 2, students.length);
        Student student = students[0];
        service.delete(student.getId());
        students = service.findAllActiveStudents();
        Assertions.assertEquals(STUDENTS_SIZE + 1, students.length);

    }

    @Test
    void findAllActiveGroups() {
    }
}