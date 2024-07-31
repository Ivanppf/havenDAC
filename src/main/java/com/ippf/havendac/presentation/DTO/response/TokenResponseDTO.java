package com.ippf.havendac.presentation.DTO.response;

import com.ippf.havendac.model.entities.User;

public record TokenResponseDTO(String bearer, User user) {
}
