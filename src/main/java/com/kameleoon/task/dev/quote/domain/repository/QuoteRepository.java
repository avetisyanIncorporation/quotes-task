package com.kameleoon.task.dev.quote.domain.repository;

import com.kameleoon.task.dev.quote.domain.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Pargev A. created on 09.02.2023
 */
public interface QuoteRepository extends JpaRepository<Quote, Long> {

    @Query(value = "SELECT * FROM quote ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Quote getRandomQuote();

    @Query(value = "SELECT * FROM quote ORDER BY score desc LIMIT 10", nativeQuery = true)
    List<Quote> getTop10();

    @Query(value = "SELECT * FROM quote ORDER BY score asc LIMIT 10", nativeQuery = true)
    List<Quote> getWorse10();
}
