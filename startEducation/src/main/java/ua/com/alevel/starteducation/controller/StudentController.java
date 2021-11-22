package ua.com.alevel.starteducation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.starteducation.dto.request.StudentDtoRequest;
import ua.com.alevel.starteducation.dto.response.ResponseContainer;
import ua.com.alevel.starteducation.dto.response.StudentDtoResponse;
import ua.com.alevel.starteducation.facade.StudentFacade;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentFacade studentFacade;

    public StudentController(StudentFacade studentFacade) {
        this.studentFacade = studentFacade;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    private ResponseEntity<ResponseContainer<Boolean>> create(@Valid @RequestBody StudentDtoRequest dto) {
        studentFacade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseContainer<>(true));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    private ResponseEntity<ResponseContainer<Boolean>> update(@RequestBody StudentDtoRequest dto, @PathVariable Long id) {
        studentFacade.update(dto, id);
        return ResponseEntity.ok().body(new ResponseContainer<>(true));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<ResponseContainer<Boolean>> delete(@PathVariable Long id) {
        studentFacade.delete(id);
        return ResponseEntity.ok().body(new ResponseContainer<>(true));
    }

    @GetMapping("/{id}")
    private ResponseEntity<ResponseContainer<StudentDtoResponse>> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(new ResponseContainer<>(studentFacade.findById(id)));
    }

    @GetMapping()
    private ResponseEntity<ResponseContainer<List<StudentDtoResponse>>> findAll() {
        return ResponseEntity.ok(new ResponseContainer<>(studentFacade.findAll()));
    }

    @GetMapping("/teacher")
    private ResponseEntity<ResponseContainer<List<StudentDtoResponse>>> findAllByTeacher(@RequestParam Long teacherId) {
        studentFacade.findAllByTeacher(teacherId);
        return ResponseEntity.ok(new ResponseContainer<>(studentFacade.findAllByTeacher(teacherId)));
    }
}
