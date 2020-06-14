package service.impl;

import entity.Card;
import repository.CardRepository;
import repository.impl.CardRepositoryImpl;
import service.CardService;

import java.util.List;

public class CardServiceImpl implements CardService {

    private CardRepository cardRepository = new CardRepositoryImpl();

    @Override
    public List<Card> findAllCardsByOwner(String owner) {
        return cardRepository.findAllCardsByOwner(owner);
    }

    @Override
    public List<Card> findAllAccountCardsByAccountId(Long id) {
        return cardRepository.findAllAccountCardsByAccountId(id);
    }

    @Override
    public void saveOrUpdate(Card card) {
        if (card.getId() == null) {
            long id = findAll().size();
            card.setId(++id);
            cardRepository.save(card);
        } else {
            cardRepository.update(card);
        }
    }

    @Override
    public Card findById(Long id) {
        return cardRepository.findById(id);
    }

    @Override
    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    @Override
    public void remove(Long id) {
        cardRepository.remove(id);
    }

    public CardRepository getCardRepository() {
        return cardRepository;
    }

    public void setCardRepository(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }
}


