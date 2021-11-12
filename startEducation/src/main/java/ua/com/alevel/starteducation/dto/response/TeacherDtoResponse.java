package ua.com.alevel.starteducation.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.com.alevel.starteducation.model.Teacher;

@Setter
@Getter
@NoArgsConstructor
public class TeacherDtoResponse {

    private String firstName;
    private String lastName;
    private Long id;
    private String email;

    public TeacherDtoResponse(Teacher teacher) {
        this.firstName = teacher.getFirstName();
        this.lastName = teacher.getLastName();
        this.id = teacher.getId();
        this.email = teacher.getEmail();
    }
}

