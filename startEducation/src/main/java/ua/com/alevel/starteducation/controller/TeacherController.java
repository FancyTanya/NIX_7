package ua.com.alevel.starteducation.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.starteducation.dto.request.TeacherDtoRequest;
import ua.com.alevel.starteducation.dto.response.ResponseContainer;
import ua.com.alevel.starteducation.dto.response.TeacherDtoResponse;
import ua.com.alevel.starteducation.facade.TeacherFacade;

import java.util.List;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    private final TeacherFacade teacherFacade;

    public TeacherController(TeacherFacade teacherFacade) {
        this.teacherFacade = teacherFacade;
    }

    @PostMapping
    private ResponseEntity<ResponseContainer<Boolean>> create(@RequestBody TeacherDtoRequest dto) {
        teacherFacade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseContainer<>(true));
    }

    @PutMapping("/{id}")
    private ResponseEntity<ResponseContainer<Boolean>> update(@RequestBody TeacherDtoRequest dto, @PathVariable Long id) {
        teacherFacade.update(dto, id);
        return ResponseEntity.ok().body(new ResponseContainer<>(true));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<ResponseContainer<Boolean>> delete(@PathVariable Long id) {
        teacherFacade.delete(id);
        return ResponseEntity.ok().body(new ResponseContainer<>(true));
    }

    @GetMapping("/{id}")
    private ResponseEntity<ResponseContainer<TeacherDtoResponse>> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(new ResponseContainer<>(teacherFacade.findById(id)));
    }

    @GetMapping()
    private ResponseEntity<ResponseContainer<List<TeacherDtoResponse>>> findAll() {
        return ResponseEntity.ok().body(new ResponseContainer<>(teacherFacade.findAll()));
    }
}
