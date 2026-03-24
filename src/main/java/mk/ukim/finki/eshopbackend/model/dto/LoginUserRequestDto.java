package mk.ukim.finki.eshopbackend.model.dto;

public record LoginUserRequestDto(
    String username,
    String password
) {
}
