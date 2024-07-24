package com.ippf.havendac.presentation.DTO.request;

import jakarta.validation.constraints.Email;

public record UserRequestDTO(
        String name,
        String username,
        @Email String email,
        String password
) {
}
