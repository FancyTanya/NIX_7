package ua.com.alevel.starteducation.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.com.alevel.starteducation.model.Lesson;

import java.time.OffsetDateTime;
@Setter
@Getter
@NoArgsConstructor
public class LessonDtoResponse {

    private String title;
    private OffsetDateTime date;
    private boolean isComplete;
    private Long id;
    private Long teacherId;

    public LessonDtoResponse(Lesson lesson) {
        this.title = lesson.getTitle();
        this.date = lesson.getDate();
        this.isComplete = lesson.isComplete();
        this.id = lesson.getId();
        if (lesson.getTeacher() != null) {
            this.teacherId = lesson.getTeacher().getId();
        }
    }
}
