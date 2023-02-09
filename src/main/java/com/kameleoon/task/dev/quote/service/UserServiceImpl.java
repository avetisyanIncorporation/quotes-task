package com.kameleoon.task.dev.quote.service;

import com.kameleoon.task.dev.quote.domain.dto.UserDTO;
import com.kameleoon.task.dev.quote.domain.entity.User;
import com.kameleoon.task.dev.quote.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Pargev A. created on 09.02.2023
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public boolean createNewUser(UserDTO newUser) {
        if (userRepository.findByLogin(newUser.getLogin()).isPresent()) {
            return false;
        }
        var user = new User(newUser.getLogin(), passwordEncoder.encode(newUser.getPassword()));
        userRepository.save(user);
        return true;
    }

    @Override
    public User getUserById(long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Have no User by id=" + userId));
    }
}
