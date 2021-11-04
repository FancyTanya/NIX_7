package ua.com.alevel.starteducation.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.com.alevel.starteducation.model.Student;

@Setter
@Getter
@NoArgsConstructor
public class StudentDtoResponse {

    private String firstName;
    private String lastName;
    private Long teacherId;
    private Long id;
    private String email;

    public StudentDtoResponse(Student student) {
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email =student.getEmail();
        this.id = student.getId();
        if (student.getTeacher() != null) {
            this.teacherId = student.getTeacher().getId();
        }
    }
}
