package com.kameleoon.task.dev.quote.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Pargev A. created on 09.02.2023
 */
@AllArgsConstructor
@Data
public class UserDTO {
    private String login;
    private String password;
}
