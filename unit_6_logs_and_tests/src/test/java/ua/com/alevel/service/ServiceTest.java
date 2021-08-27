package ua.com.alevel.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.com.alevel.dao.CourseDao;
import ua.com.alevel.dao.GroupOfStudentsDao;
import ua.com.alevel.dao.StudentDao;
import ua.com.alevel.entity.Course;
import ua.com.alevel.entity.GroupOfStudents;
import ua.com.alevel.entity.Student;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {
    public static final Service service = Service.getInstance();
    public static CourseDao course = new CourseDao();
    private final static int STUDENTS_SIZE = 10;

//    @BeforeAll
//    void initialization() {
//        CourseDao courseDao = new CourseDao();
//
//    }

    @Test
    void setup() {
        for (int i = 0; i < STUDENTS_SIZE; i++) {
            StudentDao studentDao1 = new StudentDao();
            StudentDao studentDao2 = new StudentDao();
            Student student1 = new Student();
            student1.setFirstName("first" + i);
            student1.setLastName("last" + i);
            Student student2 = new Student();
            student2.setFirstName("first" + i);
            student2.setLastName("last" + i);
            Course course = new Course();
            course.setTitle("Course");
            student1.setCourse(course);//findIdByFullTitle(course) тут null потому что не
            //в базе данных ArrayDB ты не положила ничего на етом етапе. Смотри ты создала student1 с полями имя и
            // фамилия студента 2 также и нету через дао слой пложенного в базу данных ничего только созданно 2 обэкта
//           // student1 student2 а ниже в student2.setCourse(service.findIdByFullTitle(course)); ты пытаеся взять с базы
//           данные которые не ложила туда...
            student2.setCourse(course);
            student1.isActive();
            student2.isActive();
            studentDao1.create(student1);
            studentDao2.create(student2);
            Student[] students = {student1, student2};
            service.createGroupOfStudents(course.getTitle(), students);

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
        StudentDao studentDao1 = new StudentDao();
        StudentDao studentDao2 = new StudentDao();
        studentDao1.create(studentOne);
        studentDao2.create(studentTwo);
        Student[] students = {studentOne, studentTwo};
        Course course = new Course();
        course.setTitle("Course");
        studentOne.setCourse(course);
        studentTwo.setCourse(course);
        service.createGroupOfStudents(course.getTitle(), students);

        Assertions.assertEquals(service.findAllActiveGroups().length, 1);


//        Assertions.assertEquals(group.getStudents().length, service.findAllActiveStudents().length);

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