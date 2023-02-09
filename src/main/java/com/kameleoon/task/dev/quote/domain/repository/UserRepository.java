package com.kameleoon.task.dev.quote.domain.repository;

import com.kameleoon.task.dev.quote.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Pargev A. created on 09.02.2023
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);

}
