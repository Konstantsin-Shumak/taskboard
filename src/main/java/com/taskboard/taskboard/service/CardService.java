package com.taskboard.taskboard.service;

import com.taskboard.taskboard.domain.Card;
import com.taskboard.taskboard.dto.CardResponse;
import com.taskboard.taskboard.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Card createCard(Card card) {
        return cardRepository.save(card);
    }

    public CardResponse toResponse(Card card) {
        CardResponse response = new CardResponse();
        response.setId(card.getId());
        response.setTitle(card.getTitle());
        response.setDescription(card.getDescription());
        response.setCreatedAt(card.getCreatedAt());
        response.setColumnId(card.getBoardColumn().getId());
        return response;
    }

    public List<CardResponse> getAllCardResponses() {
        return cardRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }
}
