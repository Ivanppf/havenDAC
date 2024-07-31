package com.ippf.havendac.presentation.DTO.response;

import com.ippf.havendac.model.entities.Role;
import com.ippf.havendac.model.entities.User;

import java.util.List;

public record UserResponseDTO(
        Integer id,
        String name,
        String nickname,
        String email,
        List<Role> roles
) {
    public UserResponseDTO(User user) {
        this(user.getUserId(), user.getName(), user.getNickname(), user.getEmail(), user.getRoles());
    }
}
