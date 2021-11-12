package ua.com.alevel.starteducation.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.com.alevel.starteducation.model.Topic;

@Setter
@Getter
@NoArgsConstructor
public class TopicDtoResponse {

    private String name;
    private Long teacherId;

    public TopicDtoResponse (Topic topic) {
        this.name = topic.getName();
        this.teacherId = topic.getTeacher().getId();
    }
}
