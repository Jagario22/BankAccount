package repository.impl;

import entity.Card;
import repository.CardRepository;

import java.util.ArrayList;
import java.util.List;

public class CardRepositoryImpl implements CardRepository {
    private List<Card> cardList = new ArrayList<Card>();

    @Override
    public List<Card> findAllCardsByOwner(String owner) {
        List<Card> cards = new ArrayList<Card>();
        for(Card i: cardList)
        {
            if (i.getOwner().equals(owner))
            {
                cards.add(i);
            }
        }
        return cards;
    }

    @Override
    public List<Card> findAllAccountCardsByAccountId(Long id) {
        List<Card> cards = new ArrayList<Card>();
        for (Card i: cardList)
        {
           if (i.getAccountId().equals(id)) {
               cards.add(i);
           }
        }
        return cards;
    }

    @Override
    public void save(Card card) {
        cardList.add(card);
    }

    @Override
    public Card findById(Long id) {
        for (Card i: cardList)
        {
            if (i.getId().equals(id))
            {
                return i;
            }
        }
        return null;
    }

    @Override
    public List<Card> findAll() {
        return cardList;
    }

    @Override
    public void update(Card card) {
        for (Card i: cardList)
        {
            if (card.getId().equals(i.getId()))
            {
                i.setBalance(card.getBalance());
                i.setAccountId(card.getAccountId());
                i.setIdentCode(card.getIdentCode());
                i.setOwner(card.getOwner());
            }
        }
    }

    @Override
    public void remove(Long id) {
        for (int i = 0; i < cardList.size(); i++)
        {
            if (cardList.get(i).getId().equals(id))
            {
                cardList.remove(i);
                return;
            }
        }
    }
}
