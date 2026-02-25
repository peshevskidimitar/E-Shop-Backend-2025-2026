package mk.ukim.finki.eshopbackend.service.application;

import java.util.List;
import java.util.Optional;
import mk.ukim.finki.eshopbackend.model.dto.CreateCategoryDto;
import mk.ukim.finki.eshopbackend.model.dto.DisplayCategoryDto;

public interface CategoryApplicationService {
    Optional<DisplayCategoryDto> findById(Long id);

    List<DisplayCategoryDto> findAll();

    DisplayCategoryDto create(CreateCategoryDto createCategoryDto);

    Optional<DisplayCategoryDto> update(Long id, CreateCategoryDto createCategoryDto);

    Optional<DisplayCategoryDto> deleteById(Long id);
}
