package service;

import entity.Card;

import java.util.List;

public interface CardService extends AbstractService<Card> {
    List<Card> findAllCardsByOwner(String owner);
    List<Card> findAllAccountCardsByAccountId(Long id);
}
