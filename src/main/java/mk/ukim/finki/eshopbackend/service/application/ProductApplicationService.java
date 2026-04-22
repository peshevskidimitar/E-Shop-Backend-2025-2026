package mk.ukim.finki.eshopbackend.service.application;

import java.util.List;
import java.util.Optional;
import mk.ukim.finki.eshopbackend.model.dto.CreateProductDto;
import mk.ukim.finki.eshopbackend.model.dto.DisplayProductDetailsDto;
import mk.ukim.finki.eshopbackend.model.dto.DisplayProductDto;
import org.springframework.data.domain.Page;

public interface ProductApplicationService {
    Optional<DisplayProductDto> findById(Long id);

    Optional<DisplayProductDetailsDto> findWithDetailsById(Long id);

    List<DisplayProductDto> findAll();

    DisplayProductDto create(CreateProductDto createProductDto);

    Optional<DisplayProductDto> update(Long id, CreateProductDto createProductDto);

    Optional<DisplayProductDto> deleteById(Long id);

    Page<DisplayProductDto> findAll(int page, int size, String sortBy);
}
