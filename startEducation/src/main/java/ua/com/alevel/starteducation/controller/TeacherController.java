package ua.com.alevel.starteducation.controller;


import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.starteducation.dto.request.TeacherDtoRequest;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @PostMapping
    private ResponseEntity create(TeacherDtoRequest dto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @PutMapping("/{id}")
    private ResponseEntity update(TeacherDtoRequest dto, @PathVariable Long id) {

        return ResponseEntity.ok().body(null);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity delete(@PathVariable Long id) {

        return ResponseEntity.ok().body(null);
    }

    @GetMapping("/{id}")
    private ResponseEntity findById(@PathVariable Long id) {

        return ResponseEntity.ok().body(null);
    }

    @GetMapping()
    private ResponseEntity findAll() {

        return ResponseEntity.ok().body(null);
    }
}
