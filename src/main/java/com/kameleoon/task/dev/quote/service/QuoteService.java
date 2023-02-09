package com.kameleoon.task.dev.quote.service;

import com.kameleoon.task.dev.quote.domain.dto.QuoteDTO;
import com.kameleoon.task.dev.quote.domain.entity.Quote;

import java.util.List;

/**
 * @author Pargev A. created on 09.02.2023
 */
public interface QuoteService {
    /**
     * Создает новую сущность "запись".
     *
     * @param newQuote данные новой квоты
     * @return Созданая запись из БД
     */
    Quote createQuote(QuoteDTO newQuote);

    /**
     * Возвращает рандомную квоту.
     *
     * @return найденная рандомная квота.
     */
    Quote getRandomQuote();

    /**
     * Удаляет квоту по ИД.
     *
     * @param quoteId ИД записи в БД
     */
    void deleteQuoteById(long quoteId);

    /**
     * Изменяет контент записи.
     *
     * @param changedQuote ДТО с новым контентом.
     * @return измененная квота
     */
    Quote changeQuote(QuoteDTO changedQuote);

    /**
     * Инкрементирует рейтинг записи.
     *
     * @param quoteId ИД записи
     * @return новый рейтинг
     */
    long upVote(long quoteId);

    /**
     * Декрементирует рейтинг записи.
     *
     * @param quoteId ИД записи
     * @return новый рейтинг
     */
    long downVote(long quoteId);

    /**
     * Возвращает топ 10 записей (по рейтингу).
     *
     * @return топ 10 записей
     */
    List<Quote> getTop10Quotes();

    /**
     * Возвращает худшие 10 записей (по рейтингу).
     *
     * @return худшие 10 записей
     */
    List<Quote> getWorse10Quotes();
}
