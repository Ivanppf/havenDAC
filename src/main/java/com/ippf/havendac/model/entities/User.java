package com.ippf.havendac.model.entities;

import com.ippf.havendac.presentation.DTO.request.UserRequestDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tb_user")
@Data
@NoArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String name;
    private String nickname;
    private String email;
    private String password;
    private List<Role> roles;

    public User(UserRequestDTO userRequestDTO) {
        this.name = userRequestDTO.name();
        this.nickname = userRequestDTO.nickname();
        this.email = userRequestDTO.email();
        this.password = userRequestDTO.password();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        roles.forEach((role) -> {
            switch (role.getRole()) {
                case "user" -> authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                case "admin" -> {
                    authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                    authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
                }
                default -> throw new RuntimeException("Role " + role.getRole() + " not found");
            }
        });
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
