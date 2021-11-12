package ua.com.alevel.starteducation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.alevel.starteducation.model.Lesson;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findAllByTeacher(Long teacherId);
}
