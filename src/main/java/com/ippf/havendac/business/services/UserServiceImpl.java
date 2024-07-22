package com.ippf.havendac.business.services;

import com.ippf.havendac.model.entities.User;
import com.ippf.havendac.model.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User update(Integer id, User user) {
        user.setUserId(id);
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.delete(findById(id));
    }

}
