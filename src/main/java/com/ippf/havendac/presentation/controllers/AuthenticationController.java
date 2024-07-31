package com.ippf.havendac.presentation.controllers;

import com.ippf.havendac.business.services.TokenService;
import com.ippf.havendac.model.entities.User;
import com.ippf.havendac.presentation.DTO.request.AuthenticationDTO;
import com.ippf.havendac.presentation.DTO.response.TokenResponseDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthenticationController {

    private AuthenticationManager authenticationManager;
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO authenticationDTO) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(authenticationDTO.email(), authenticationDTO.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        User user = (User) auth.getPrincipal();
        user.setPassword(null);
        var token = tokenService.generateToken(user);
        return ResponseEntity.ok().body(new TokenResponseDTO(token, user));
    }

    //implementar logout
}
