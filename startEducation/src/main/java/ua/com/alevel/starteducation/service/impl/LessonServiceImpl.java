package ua.com.alevel.starteducation.service.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.starteducation.model.Lesson;
import ua.com.alevel.starteducation.repository.LessonRepository;
import ua.com.alevel.starteducation.repository.TeacherRepository;
import ua.com.alevel.starteducation.service.LessonService;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;

    public LessonServiceImpl(LessonRepository lessonRepository, TeacherRepository teacherRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public void create(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    @Override
    public void update(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    @Override
    public void delete(Long id) {
        lessonRepository.deleteById(id);
    }

    @Override
    public boolean existById(Long id) {
        return lessonRepository.existsById(id);
    }

    @Override
    public Lesson findById(Long id) {
        return lessonRepository.findById(id).get();
    }

    @Override
    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    @Override
    public List<Lesson> findAllByTeacher(Long teacherId) {
        return lessonRepository.findAllByTeacher(teacherId);
    }
}
