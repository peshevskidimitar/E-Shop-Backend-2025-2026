package mk.ukim.finki.eshopbackend.service.application;

import java.util.List;
import java.util.Optional;
import mk.ukim.finki.eshopbackend.model.dto.CreateProductDto;
import mk.ukim.finki.eshopbackend.model.dto.DisplayProductDto;

public interface ProductApplicationService {
    Optional<DisplayProductDto> findById(Long id);

    List<DisplayProductDto> findAll();

    DisplayProductDto create(CreateProductDto createProductDto);

    Optional<DisplayProductDto> update(Long id, CreateProductDto createProductDto);

    Optional<DisplayProductDto> deleteById(Long id);
}
