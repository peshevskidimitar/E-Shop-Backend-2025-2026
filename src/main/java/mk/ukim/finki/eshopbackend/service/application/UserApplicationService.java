package mk.ukim.finki.eshopbackend.service.application;

import java.util.Optional;
import mk.ukim.finki.eshopbackend.model.dto.LoginUserRequestDto;
import mk.ukim.finki.eshopbackend.model.dto.LoginUserResponseDto;
import mk.ukim.finki.eshopbackend.model.dto.RegisterUserRequestDto;
import mk.ukim.finki.eshopbackend.model.dto.RegisterUserResponseDto;

public interface UserApplicationService {
    Optional<RegisterUserResponseDto> register(RegisterUserRequestDto registerUserRequestDto);

    Optional<LoginUserResponseDto> login(LoginUserRequestDto loginUserRequestDto);

    Optional<RegisterUserResponseDto> findByUsername(String username);
}
