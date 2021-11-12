package ua.com.alevel.starteducation.service.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.starteducation.model.Grade;
import ua.com.alevel.starteducation.repository.GradeRepository;
import ua.com.alevel.starteducation.service.GradeService;

import java.util.List;
@Service
public class GradeServiceImpl implements GradeService {

    private final GradeRepository gradeRepository;

    public GradeServiceImpl(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Override
    public void create(Grade grade) {
        gradeRepository.save(grade);
    }

    @Override
    public void update(Grade grade) {
        gradeRepository.save(grade);
    }

    @Override
    public void delete(Long id) {
        gradeRepository.deleteById(id);
    }

    @Override
    public boolean existById(Long id) {
        return gradeRepository.existsById(id);
    }

    @Override
    public Grade findById(Long id) {
        return gradeRepository.findById(id).get();
    }

    @Override
    public List<Grade> findAll() {
        return gradeRepository.findAll();
    }

    public List<Grade> findAllByStudent(Long studentId) {
        return gradeRepository.findAllByStudent(studentId);
    }
}
