package com.kameleoon.task.dev.quote.service;

import com.kameleoon.task.dev.quote.domain.dto.QuoteDTO;
import com.kameleoon.task.dev.quote.domain.entity.Quote;
import com.kameleoon.task.dev.quote.domain.repository.QuoteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Pargev A. created on 09.02.2023
 */
@Service
public class QuoteServiceImpl implements QuoteService {

    private final QuoteRepository quoteRepository;
    private final UserService userService;

    @Autowired
    public QuoteServiceImpl(QuoteRepository quoteRepository, UserService userService) {
        this.quoteRepository = quoteRepository;
        this.userService = userService;
    }

    @Override
    public Quote createQuote(QuoteDTO newQuote) {
        var user = userService.getUserById(newQuote.getUserId());
        var quote = new Quote(newQuote.getDescription(), user);
        return quoteRepository.save(quote);
    }

    @Override
    public Quote getRandomQuote() {
        return quoteRepository.getRandomQuote();
    }

    @Override
    public void deleteQuoteById(long quoteId) {
        quoteRepository.deleteById(quoteId);
    }

    @Override
    @Transactional
    public Quote changeQuote(QuoteDTO changedQuote) {
        var quote = quoteRepository.findById(changedQuote.getQuoteId())
                        .orElseThrow(() -> new IllegalArgumentException("Have no Quote by id=" + changedQuote.getQuoteId()));
        quote.setDescription(changedQuote.getDescription());
        quote.setLastUpdate(LocalDateTime.now());
        return quoteRepository.save(quote);
    }

    @Override
    @Transactional
    public long upVote(long quoteId) {
        var quote = quoteRepository.findById(quoteId)
                .orElseThrow(() -> new IllegalArgumentException("Have no Quote by id=" + quoteId));
        var score = quote.getScore();
        quote.setScore(++score);
        quoteRepository.save(quote);
        return score;
    }

    @Override
    @Transactional
    public long downVote(long quoteId) {
        var quote = quoteRepository.findById(quoteId)
                .orElseThrow(() -> new IllegalArgumentException("Have no Quote by id=" + quoteId));
        var score = quote.getScore();
        if (score > 0) {
            quote.setScore(--score);
            quoteRepository.save(quote);
            return score;
        }
        throw new IllegalArgumentException("Score < 0 for quote by id=" + quoteId);
    }

    @Override
    public List<Quote> getTop10Quotes() {
        return quoteRepository.getTop10();
    }

    @Override
    public List<Quote> getWorse10Quotes() {
        return quoteRepository.getWorse10();
    }
}
