package com.ippf.havendac.presentation.controllers;

import com.ippf.havendac.business.services.UserService;
import com.ippf.havendac.model.entities.User;
import com.ippf.havendac.presentation.DTO.request.UserRequestDTO;
import com.ippf.havendac.presentation.DTO.response.UserResponseDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Integer id) {
        try {
            User user = userService.findById(id);
            return ResponseEntity.ok(new UserResponseDTO(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity save(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        try {
            User user = new User(userRequestDTO);
            UserResponseDTO userResponseDTO = new UserResponseDTO(userService.save(user));
            return new ResponseEntity(userResponseDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Integer id, @Valid @RequestBody UserRequestDTO userRequestDTO) {
        try {
            User user = new User(userRequestDTO);
            user.setUserId(id);
            UserResponseDTO userResponseDTO = new UserResponseDTO(userService.save(user));
            return new ResponseEntity(userResponseDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteById(@PathVariable("id") Integer id) {
        try {
            userService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
