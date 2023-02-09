package com.kameleoon.task.dev.quote.controller;

import com.kameleoon.task.dev.quote.domain.dto.UserDTO;
import com.kameleoon.task.dev.quote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Pargev A. created on 09.02.2023
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "create")
    public ResponseEntity<?> createUser(@ModelAttribute UserDTO newUser) {
        var status = userService.createNewUser(newUser) ?
                HttpStatus.CREATED :
                HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).build();
    }
}
