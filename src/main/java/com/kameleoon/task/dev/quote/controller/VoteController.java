package com.kameleoon.task.dev.quote.controller;

import com.kameleoon.task.dev.quote.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Pargev A. created on 09.02.2023
 */
@Controller
@RequestMapping(value = "vote")
public class VoteController {

    private final QuoteService quoteService;

    @Autowired
    public VoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @PostMapping(value = "upToQuote/{quoteId}")
    public @ResponseBody Long upVoteToQuote(@PathVariable long quoteId) {
        return quoteService.upVote(quoteId);
    }

    @PostMapping(value = "downToQuote/{quoteId}")
    public @ResponseBody Long downVoteToQuote(@PathVariable long quoteId) {
        return quoteService.downVote(quoteId);
    }

}
