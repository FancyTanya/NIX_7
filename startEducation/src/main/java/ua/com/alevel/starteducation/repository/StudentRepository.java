package ua.com.alevel.starteducation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.alevel.starteducation.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
