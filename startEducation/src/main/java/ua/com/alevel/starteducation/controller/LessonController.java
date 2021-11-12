package ua.com.alevel.starteducation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.starteducation.dto.request.LessonDtoRequest;
import ua.com.alevel.starteducation.dto.response.ResponseContainer;
import ua.com.alevel.starteducation.facade.LessonFacade;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {
    private final LessonFacade lessonFacade;

    public LessonController(LessonFacade lessonFacade) {
        this.lessonFacade = lessonFacade;
    }

    @PostMapping
    private ResponseEntity create(LessonDtoRequest dto,@RequestParam Long teacherId) {
        lessonFacade.create(dto, teacherId);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseContainer<>(true));
    }

    @PutMapping("/{id}")
    private ResponseEntity update(LessonDtoRequest dto, @PathVariable Long id) {
        lessonFacade.update(dto, id);
        return ResponseEntity.ok(new ResponseContainer<>(true));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity delete(@PathVariable Long id) {
        lessonFacade.delete(id);
        return ResponseEntity.ok(new ResponseContainer<>(true));
    }

    @GetMapping("/{id}")
    private ResponseEntity findById(@PathVariable Long id) {
        return ResponseEntity.ok(new ResponseContainer<>(lessonFacade.findById(id)));
    }

    @GetMapping()
    private ResponseEntity findAll() {
        return ResponseEntity.ok(new ResponseContainer<>(lessonFacade.findAll()));
    }

    @GetMapping("/teacher")
    private ResponseEntity findAllByTeacher(@RequestParam Long teacherId) {
        return ResponseEntity.ok(new ResponseContainer<>(lessonFacade.findAllByTeacher(teacherId)));
    }
}
