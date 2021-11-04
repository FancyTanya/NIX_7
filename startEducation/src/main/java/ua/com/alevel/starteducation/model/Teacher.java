package ua.com.alevel.starteducation.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name = "teachers")
public class Teacher extends BaseEntity{

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "teacher")
    private List<Topic> topics;

    @OneToMany(mappedBy = "teacher")
    private List<Lesson> lessons;
}
