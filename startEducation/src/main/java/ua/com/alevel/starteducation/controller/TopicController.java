package ua.com.alevel.starteducation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.starteducation.dto.request.TopicDtoRequest;
import ua.com.alevel.starteducation.dto.response.ResponseContainer;
import ua.com.alevel.starteducation.dto.response.TopicDtoResponse;
import ua.com.alevel.starteducation.facade.TopicFacade;

import java.util.List;

@RestController
@RequestMapping("/api/topics")
public class TopicController {

    private final TopicFacade topicFacade;

    public TopicController(TopicFacade topicFacade) {
        this.topicFacade = topicFacade;
    }

    @PostMapping()
    private ResponseEntity<ResponseContainer<Boolean>> create(TopicDtoRequest dto, @RequestParam Long teacherId) {
        topicFacade.create(dto, teacherId);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseContainer<>(true));
    }

    @PutMapping("/{id}")
    private ResponseEntity<ResponseContainer<Boolean>> update(TopicDtoRequest dto, @PathVariable Long id) {
        topicFacade.update(dto, id);
        return ResponseEntity.ok(new ResponseContainer<>(true));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<ResponseContainer<Boolean>> delete(@PathVariable Long id) {
        topicFacade.delete(id);
        return ResponseEntity.ok(new ResponseContainer<>(true));
    }

    @GetMapping("/{id}")
    private ResponseEntity<ResponseContainer<TopicDtoResponse>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(new ResponseContainer<>(topicFacade.findById(id)));
    }

    @GetMapping()
    private ResponseEntity<ResponseContainer<List<TopicDtoResponse>>> findAll() {
        return ResponseEntity.ok(new ResponseContainer<>(topicFacade.findAll()));
    }

    @GetMapping("/teacher")
    private ResponseEntity findAllByTeacher(@RequestParam Long teacherId) {
        return ResponseEntity.ok(new ResponseContainer<>(topicFacade.findAllByTeacher(teacherId)));
    }
}
