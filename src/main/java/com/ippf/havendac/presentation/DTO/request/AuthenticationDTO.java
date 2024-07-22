package com.ippf.havendac.presentation.DTO.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record AuthenticationDTO(
        @NotNull(message = "Please, type an email") @Email(message = "Please, type a valid email") String email,
        @NotNull(message = "Please, type a password") String password
) {
}
