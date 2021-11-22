package ua.com.alevel.starteducation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.starteducation.dto.request.GradeDtoRequest;
import ua.com.alevel.starteducation.dto.response.GradeDtoResponse;
import ua.com.alevel.starteducation.dto.response.ResponseContainer;
import ua.com.alevel.starteducation.facade.GradeFacade;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/grades")
public class GradeController {

    private final GradeFacade gradeFacade;

    public GradeController(GradeFacade gradeFacade) {
        this.gradeFacade = gradeFacade;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    private ResponseEntity<ResponseContainer<Boolean>> create(@Valid GradeDtoRequest dto, @RequestParam Long studentId) {
        gradeFacade.create(dto, studentId);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseContainer<>(true));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    private ResponseEntity<ResponseContainer<Boolean>> update(GradeDtoRequest dto, @PathVariable Long id) {
        gradeFacade.update(dto, id);
        return ResponseEntity.ok(new ResponseContainer<>(true));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<ResponseContainer<Boolean>> delete(@PathVariable Long id) {
        gradeFacade.delete(id);
        return ResponseEntity.ok(new ResponseContainer<>(true));
    }

    @GetMapping("/{id}")
    private ResponseEntity<ResponseContainer<GradeDtoResponse>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(new ResponseContainer<>(gradeFacade.findById(id)));
    }

    @GetMapping()
    private ResponseEntity<ResponseContainer<List<GradeDtoResponse>>> findAll() {
        return ResponseEntity.ok(new ResponseContainer<>(gradeFacade.findAll()));
    }

    @GetMapping("/student")
    private ResponseEntity<ResponseContainer<List<GradeDtoResponse>>> findAllByStudent(@PathVariable Long id) {
        return ResponseEntity.ok(new ResponseContainer<>(gradeFacade.findAllByStudent(id)));
    }
}
