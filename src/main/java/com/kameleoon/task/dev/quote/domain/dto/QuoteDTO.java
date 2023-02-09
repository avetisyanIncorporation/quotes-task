package com.kameleoon.task.dev.quote.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Pargev A. created on 09.02.2023
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class QuoteDTO {
    private long quoteId;
    private long userId;
    private String description;
}
