package ua.com.alevel.starteducation.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.com.alevel.starteducation.dto.response.ResponseContainer;
import ua.com.alevel.starteducation.model.Topic;

public interface TopicService extends CrudService<Topic>{
    Page<Topic> findAllByTeacher(Long teacherId, Pageable pageable);
}
