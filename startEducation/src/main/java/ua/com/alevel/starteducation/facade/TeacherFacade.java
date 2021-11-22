package ua.com.alevel.starteducation.facade;

import org.springframework.data.domain.Pageable;
import ua.com.alevel.starteducation.dto.request.TeacherDtoRequest;
import ua.com.alevel.starteducation.dto.response.TeacherDtoResponse;

import java.util.List;

public interface TeacherFacade {

    void create(TeacherDtoRequest dto);

    void update(TeacherDtoRequest dto, Long id);

    void delete(Long id);

    TeacherDtoResponse findById(Long id);

    List<TeacherDtoResponse> findAll(Pageable pageable);

}
