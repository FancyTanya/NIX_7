package main.java.ua.com.alevel.controller;

import main.java.ua.com.alevel.entity.Student;
import main.java.ua.com.alevel.servise.impl.CourseServiceImpl;
import main.java.ua.com.alevel.servise.impl.StudentServiceImpl;

import java.util.Scanner;

public class Controller {
    private  CourseServiceImpl courseService;
    private  StudentServiceImpl studentService;

    public Controller() {

    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String position;
        menu();
        position = scanner.nextLine();
        crud(position, scanner);
    }

    private void menu() {
        System.out.println("***********************");
        System.out.println("You can create new student. Enter 1");
        System.out.println("You can update student. Enter 2");
        System.out.println("You can delete student. Enter 3");
        System.out.println("You can find student by ID. Enter 4");
        System.out.println("You want to exit. Enter 0");
        System.out.println("***********************");
    }

    private void crud(String position, Scanner scanner) {
        switch (position) {
            case "1" : create(scanner); break;
            case "2" : update(scanner); break;
            case "3" : delete(scanner); break;
            case "4" : findById(scanner); break;
            case "0" : System.exit(0);
        }
        menu();
    }

    private void create(Scanner scanner) {
        Student newStudent = getNewStudent(scanner);
        studentService.create(newStudent);
    }

    private Student getNewStudent(Scanner scanner) {
        System.out.println("Student create");
        System.out.println("Please, enter phone number for ID");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Please, enter First name");
        String firstName = scanner.nextLine();
        System.out.println("Please, enter Last name");
        String lastName = scanner.nextLine();
        Student newStudent = new Student();
        newStudent.setId(id);
        newStudent.setFirsName(firstName);
        newStudent.setLastName(lastName);
        return newStudent;
    }

    private void update(Scanner scanner) {
        System.out.println("Student update");
        Student newStudent = getNewStudent(scanner);
        studentService.update(newStudent);
    }

    private void delete(Scanner scanner) {
        System.out.println("Student delete");
        Student newStudent = getNewStudent(scanner);
        studentService.delete(newStudent.getId());
    }

    private void findById(Scanner scanner) {
        System.out.println("Find student by ID");
        int id = Integer.parseInt(scanner.nextLine());
        studentService.findById(id);
    }
}
