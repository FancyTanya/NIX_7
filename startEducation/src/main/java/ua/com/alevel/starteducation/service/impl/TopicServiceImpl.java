package ua.com.alevel.starteducation.service.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.starteducation.model.Topic;
import ua.com.alevel.starteducation.repository.TopicRepository;
import ua.com.alevel.starteducation.service.TopicService;

import java.util.List;
@Service
public class TopicServiceImpl implements TopicService {

    private final TopicRepository topicRepository;

    public TopicServiceImpl(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    @Override
    public void create(Topic topic) {
        topicRepository.save(topic);
    }

    @Override
    public void update(Topic topic) {
        topicRepository.save(topic);
    }

    @Override
    public void delete(Long id) {
        topicRepository.deleteById(id);
    }

    @Override
    public boolean existById(Long id) {
        return topicRepository.existsById(id);
    }

    @Override
    public Topic findById(Long id) {
        return topicRepository.getById(id);
    }

    @Override
    public List<Topic> findAll() {
        return topicRepository.findAll();
    }

    @Override
    public List<Topic> findAllByTeacher(Long teacherId) {
        return topicRepository.findAllByTeacher(teacherId);
    }
}
