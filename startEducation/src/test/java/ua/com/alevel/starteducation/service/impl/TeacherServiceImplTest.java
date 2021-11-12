package ua.com.alevel.starteducation.service.impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ua.com.alevel.starteducation.model.Teacher;
import ua.com.alevel.starteducation.repository.TeacherRepository;
import ua.com.alevel.starteducation.service.TeacherService;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TeacherServiceImplTest {
    TeacherRepository teacherRepository;
    TeacherService teacherService;


    @BeforeAll
    void prepare() {
        teacherService = new TeacherServiceImpl(teacherRepository);
    }

    @Test
    void create() {
        teacherService.create(new Teacher());
        var teachers = teacherService.findAll();
        assertEquals(1, teachers.size());
    }

    @Test
    void update() {
        var teacherService = new TeacherServiceImpl(teacherRepository);
        teacherService.create(new Teacher());
    }

    @Test
    void delete() {
    }

    @Test
    void existById() {
    }

    @Test
    void findById() {
    }

    @Test
    void teachersEmptyIfNoTeachersAdded() {
        var teacherService = new TeacherServiceImpl(teacherRepository);
        Teacher teacher = new Teacher();
        teacher.setFirstName("first");
        teacher.setLastName("last");
        teacher.setEmail("email");
        teacher.setPassword("password");

        var teachers = teacherService.findAll();
        assertTrue(teachers.isEmpty());
    }
}