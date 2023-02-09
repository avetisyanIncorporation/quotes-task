package com.kameleoon.task.dev.quote.controller;

import com.kameleoon.task.dev.quote.domain.dto.QuoteDTO;
import com.kameleoon.task.dev.quote.domain.entity.Quote;
import com.kameleoon.task.dev.quote.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Pargev A. created on 09.02.2023
 */
@Controller
@RequestMapping(value = "quote")
public class QuoteController {

    private final QuoteService quoteService;

    @Autowired
    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @PostMapping(value = "create")
    public ResponseEntity<?> createQuote(@ModelAttribute QuoteDTO newQuote) {
        quoteService.createQuote(newQuote);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "getRandom")
    public @ResponseBody Quote getRandomQuote() {
        return quoteService.getRandomQuote();
    }

    @GetMapping(value = "getTop10")
    public @ResponseBody List<Quote> getTop10() {
        return quoteService.getTop10Quotes();
    }

    @GetMapping(value = "getWorse10")
    public @ResponseBody List<Quote> getWorse10() {
        return quoteService.getWorse10Quotes();
    }

    @PostMapping(value = "delete/{quoteId}")
    public ResponseEntity<?> deleteQuote(@PathVariable long quoteId) {
        quoteService.deleteQuoteById(quoteId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping(value = "modify")
    public ResponseEntity<?> modifyQuote(@ModelAttribute QuoteDTO changedQuote) {
        quoteService.changeQuote(changedQuote);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
