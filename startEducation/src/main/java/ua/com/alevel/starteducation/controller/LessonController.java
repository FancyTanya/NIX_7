package ua.com.alevel.starteducation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.starteducation.dto.request.LessonDtoRequest;
import ua.com.alevel.starteducation.dto.response.LessonDtoResponse;
import ua.com.alevel.starteducation.dto.response.ResponseContainer;
import ua.com.alevel.starteducation.facade.LessonFacade;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {
    private final LessonFacade lessonFacade;

    public LessonController(LessonFacade lessonFacade) {
        this.lessonFacade = lessonFacade;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    private ResponseEntity<ResponseContainer<Boolean>> create(@Valid LessonDtoRequest dto, @RequestParam Long teacherId) {
        lessonFacade.create(dto, teacherId);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseContainer<>(true));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    private ResponseEntity<ResponseContainer<Boolean>> update(LessonDtoRequest dto, @PathVariable Long id) {
        lessonFacade.update(dto, id);
        return ResponseEntity.ok(new ResponseContainer<>(true));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<ResponseContainer<Boolean>> delete(@PathVariable Long id) {
        lessonFacade.delete(id);
        return ResponseEntity.ok(new ResponseContainer<>(true));
    }

    @GetMapping("/{id}")
    private ResponseEntity<ResponseContainer<LessonDtoResponse>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(new ResponseContainer<>(lessonFacade.findById(id)));
    }

    @GetMapping()
    private ResponseEntity<ResponseContainer<List<LessonDtoResponse>>> findAll() {
        return ResponseEntity.ok(new ResponseContainer<>(lessonFacade.findAll()));
    }

    @GetMapping("/teacher")
    private ResponseEntity<ResponseContainer<List<LessonDtoResponse>>> findAllByTeacher(@RequestParam Long teacherId) {
        return ResponseEntity.ok(new ResponseContainer<>(lessonFacade.findAllByTeacher(teacherId)));
    }
}
