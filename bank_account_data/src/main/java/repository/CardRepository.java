package repository;

import entity.Account;
import entity.Card;

import java.util.List;

public interface CardRepository extends AbstractRepository<Card> {
    List<Card> findAllCardsByOwner(String owner);
    List<Card> findAllAccountCardsByAccountId(Long id);
}
