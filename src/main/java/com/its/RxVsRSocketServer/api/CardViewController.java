package com.its.RxVsRSocketServer.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.its.RxVsRSocketServer.service.CardService;
import com.its.RxVsRSocketServer.entity.CardEntity;

import java.time.Duration;

@RestController
@Slf4j
public class CardViewController {
    private final CardService cardService;

    public CardViewController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/rx/card/{cardId}")
    public Mono<CardEntity> byCardId(ServerWebExchange exchange, @PathVariable String cardId) {
        log.info("2 Entering CardViewController : byCardId");
        /*String exchangeLogIdAttribute = exchange.LOG_ID_ATTRIBUTE;
        String exchangeLogPrefix = exchange.getLogPrefix();
        log.info("ServerWebExchange meta info - exchangeLogIdAttribute : {} " +
                "and exchangeLogPrefix : {} ", exchangeLogIdAttribute, exchangeLogPrefix);*/
        return cardService
                .getCardById(cardId)
                //.delayElement(Duration.ofSeconds(1))
                //.doFinally(sig -> log.info(exchangeLogPrefix + "Response sent"));
                .doFinally(sig -> log.info("Response sent"));
    }

    @GetMapping("/rx/cards")
    public Flux<CardEntity> all() {
        log.info("Entering CardViewController : all 60 ");
        return cardService.getCards();
    }

    @GetMapping("/webclient/card/{cardId}")
    public Mono<String> fetchCardAlias(ServerWebExchange exchange, @PathVariable String cardId) {
        log.info("Entering CardViewController : fetchCardAlias with cardId : {} ", cardId);
        String exchangeLogIdAttribute = exchange.LOG_ID_ATTRIBUTE;
        String exchangeLogPrefix = exchange.getLogPrefix();
        log.info("ServerWebExchange meta info - exchangeLogIdAttribute : {} " +
                "and exchangeLogPrefix : {} ", exchangeLogIdAttribute, exchangeLogPrefix);
        return Mono
                .just("alias - " + cardId);
    }

    @MessageMapping("rsocket-fetch-all")
    public Flux<CardEntity> rSocketFetchAll() {
        log.info("Entering CardViewController : rSocketFetch 60");
        return cardService.getCards();
    }

    @MessageMapping("rsocket-find-specific")
    public Mono<CardEntity> rSocketFindSpecific(String cardId) {
        log.info("Entering CardViewController : rSocketFindSpecific with cardId : {} ", cardId);
        return cardService
                .getCardById(cardId)
                //.delayElement(Duration.ofSeconds(1))
                .doFinally(sig -> log.info("Response sent"));
    }
}
