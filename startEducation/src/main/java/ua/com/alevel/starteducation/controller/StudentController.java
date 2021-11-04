package ua.com.alevel.starteducation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.starteducation.dto.request.StudentDtoRequest;
import ua.com.alevel.starteducation.dto.response.ResponseContainer;
import ua.com.alevel.starteducation.dto.response.StudentDtoResponse;
import ua.com.alevel.starteducation.facade.StudentFacade;

public class StudentController {

    private final StudentFacade studentFacade;

    public StudentController(StudentFacade studentFacade) {
        this.studentFacade = studentFacade;
    }

    @PostMapping
    private ResponseEntity<ResponseContainer<Boolean>> create(@RequestBody StudentDtoRequest dto) {
        studentFacade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PutMapping("/{id}")
    private ResponseEntity<ResponseContainer<Boolean>> update(StudentDtoRequest dto, @PathVariable Long id) {
        studentFacade.update(dto, id);
        return ResponseEntity.ok().body(null);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<ResponseContainer<Boolean>> delete(@PathVariable Long id) {
        studentFacade.delete(id);
        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/{id}")
    private ResponseEntity<ResponseContainer<StudentDtoResponse>> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(new ResponseContainer<>(studentFacade.findById(id)));
    }

    @GetMapping()
    private ResponseEntity<ResponseContainer<StudentDtoResponse>> findAll() {
        studentFacade.findAll();
        return ResponseEntity.ok().body(null);
    }

    @GetMapping()
    private ResponseEntity<ResponseContainer<StudentDtoResponse>> findAllByTeacher(@RequestParam Long teacherId) {
        studentFacade.findAllByTeacher(teacherId);
        return ResponseEntity.ok().body(null);
    }
}
