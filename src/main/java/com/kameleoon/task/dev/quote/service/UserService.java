package com.kameleoon.task.dev.quote.service;

import com.kameleoon.task.dev.quote.domain.dto.UserDTO;
import com.kameleoon.task.dev.quote.domain.entity.User;

/**
 * @author Pargev A. created on 09.02.2023
 */
public interface UserService {

    /**
     * Создает нового пользователя. Если пользователь с таким логином сущестует, возвращает false, иначе - true.
     *
     * @param newUser Данные нового пользователя
     * @return true/false - создано/существует
     */
    boolean createNewUser(UserDTO newUser);

    User getUserById(long userId);
}
