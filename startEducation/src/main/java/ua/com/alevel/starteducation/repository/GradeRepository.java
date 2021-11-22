package ua.com.alevel.starteducation.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.alevel.starteducation.dto.response.ResponseContainer;
import ua.com.alevel.starteducation.model.Grade;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {
    Page<ResponseContainer> findAllByStudent(Long studentId, Pageable pageable);
}
