package com.taskboard.taskboard.service;

import com.taskboard.taskboard.domain.BoardColumn;
import com.taskboard.taskboard.domain.Card;
import com.taskboard.taskboard.dto.CardResponse;
import com.taskboard.taskboard.dto.CardRequest;
import com.taskboard.taskboard.repository.BoardColumnRepository;
import com.taskboard.taskboard.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;
    private final BoardColumnRepository boardColumnRepository;

    public Card createCard(CardRequest request) {
        BoardColumn column = boardColumnRepository.findById(request.getColumnId())
                .orElseThrow();
        Card card = new Card();
        card.setTitle(request.getTitle());
        card.setDescription(request.getDescription());
        card.setBoardColumn(column);

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
