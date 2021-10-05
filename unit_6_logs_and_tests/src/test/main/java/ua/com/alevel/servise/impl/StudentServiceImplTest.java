//package main.java.ua.com.alevel.servise.impl;
//
//import main.java.ua.com.alevel.entity.Student;
//import main.java.ua.com.alevel.servise.CourseService;
//import main.java.ua.com.alevel.servise.StudentService;
//import org.junit.Assert;
//import org.junit.Test;
//
//
//public class StudentServiceImplTest {
//
//    private StudentService studentService;
//    private CourseService courseService;
//    private final static int STUDENTS_SIZE = 0;
//
//    @Test
//    void create() {
//        Student student = new Student();
//        student.setId(100);
//        student.setFirsName("first");
//        student.setLastName("last");
//        studentService.create(student);
//        Student[] students = studentService.findAll();
//        Assert.assertEquals((STUDENTS_SIZE +1), students.length);
//
//    }
//
//    @Test
//    void update() {
//        Student student = studentService.findAll()[0];
//        String testName = "first last";
//
//        student.setFullName(testName);
//        student.setCourse(student.getCourse());
//        studentService.update(student);
//        Assert.assertEquals(new Student[]{studentService.findById(student.getId())}, STUDENTS_SIZE +1);
//
//    }
//
//    @Test
//    void deleteStudentById(int id) {
//        Student student = studentService.findAll()[0];
//        studentService.delete(student.getId());
//        Student[] students = studentService.findAll();
//        Assert.assertEquals(STUDENTS_SIZE, students.length);
//    }
//}