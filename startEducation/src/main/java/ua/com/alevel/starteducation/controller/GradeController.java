package ua.com.alevel.starteducation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.starteducation.dto.request.GradeDtoRequest;
import ua.com.alevel.starteducation.dto.response.ResponseContainer;
import ua.com.alevel.starteducation.facade.GradeFacade;

@RestController
@RequestMapping("/api/grades")
public class GradeController {

    private final GradeFacade gradeFacade;

    public GradeController(GradeFacade gradeFacade) {
        this.gradeFacade = gradeFacade;
    }


    @PostMapping
    private ResponseEntity create(GradeDtoRequest dto, @RequestParam Long studentId) {
        gradeFacade.create(dto, studentId);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseContainer<>(true));
    }

    @PutMapping("/{id}")
    private ResponseEntity update(GradeDtoRequest dto, @PathVariable Long id) {
        gradeFacade.update(dto, id);
        return ResponseEntity.ok(new ResponseContainer<>(true));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity delete(@PathVariable Long id) {
        gradeFacade.delete(id);
        return ResponseEntity.ok(new ResponseContainer<>(true));
    }

    @GetMapping("/{id}")
    private ResponseEntity findById(@PathVariable Long id) {
        return ResponseEntity.ok(new ResponseContainer<>(gradeFacade.findById(id)));
    }

    @GetMapping()
    private ResponseEntity findAll() {
        return ResponseEntity.ok(new ResponseContainer<>(gradeFacade.findAll()));
    }

    @GetMapping("/student")
    private ResponseEntity findAllByStudent(@PathVariable Long id) {
        return ResponseEntity.ok(new ResponseContainer<>(gradeFacade.findAllByStudent(id)));
    }
}
