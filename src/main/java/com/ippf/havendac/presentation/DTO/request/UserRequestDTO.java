package com.ippf.havendac.presentation.DTO.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record UserRequestDTO(
        @NotNull String name,
        @NotNull String nickname,
        @NotNull @Email String email,
        @NotNull String password
) {
}
