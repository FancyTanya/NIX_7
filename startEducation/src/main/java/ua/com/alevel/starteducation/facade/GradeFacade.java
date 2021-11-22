package ua.com.alevel.starteducation.facade;

import org.springframework.data.domain.Pageable;
import ua.com.alevel.starteducation.dto.request.GradeDtoRequest;
import ua.com.alevel.starteducation.dto.response.GradeDtoResponse;

import java.util.List;

public interface GradeFacade {

    void create(GradeDtoRequest dto, Long id);

    void update(GradeDtoRequest dto, Long id);

    void delete(Long id);

    GradeDtoResponse findById(Long id);

    List<GradeDtoResponse> findAll(Pageable pageable);

    List<GradeDtoResponse> findAllByStudent(Long id, Pageable pageable);
}
