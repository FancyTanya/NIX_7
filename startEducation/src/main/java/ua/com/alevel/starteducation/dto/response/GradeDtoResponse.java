package ua.com.alevel.starteducation.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.com.alevel.starteducation.model.Grade;

@Setter
@Getter
@NoArgsConstructor
public class GradeDtoResponse {

    private int grade;
    private Long lessonId;
    private Long studentId;

    public GradeDtoResponse(Grade grade) {
        this.grade = grade.getGrade();
        this.lessonId = grade.getLesson().getId();
        this.studentId = grade.getStudent().getId();
    }
}
