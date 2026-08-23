package com.taskboard.taskboard.controller;

import com.taskboard.taskboard.domain.Card;
import com.taskboard.taskboard.dto.CardRequest;
import com.taskboard.taskboard.dto.CardResponse;
import com.taskboard.taskboard.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping
    public List<CardResponse> getAllCards() {
        return cardService.getAllCardResponses();
    }

    @PostMapping
    public CardResponse createCard(@RequestBody CardRequest cardRequest) {
        Card savedCard = cardService.createCard(cardRequest);
        return cardService.toResponse(savedCard);
    }
}