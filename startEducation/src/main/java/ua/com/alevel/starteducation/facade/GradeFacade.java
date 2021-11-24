package ua.com.alevel.starteducation.facade;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.com.alevel.starteducation.dto.request.GradeDtoRequest;
import ua.com.alevel.starteducation.dto.response.GradeDtoResponse;
import ua.com.alevel.starteducation.model.Grade;

public interface GradeFacade {

    void create(GradeDtoRequest dto, Long id);

    void update(GradeDtoRequest dto, Long id);

    void delete(Long id);

    GradeDtoResponse findById(Long id);

    Page<Grade> findAll(Pageable pageable);

    Page<Grade> findAllByStudent(Long id, Pageable pageable);
}
