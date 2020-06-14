package builder;

import entity.Account;
import entity.Card;
import generator.CodeGenerator;
import service.AccountService;
import service.CardService;
import service.impl.AccountServiceImpl;
import service.impl.CardServiceImpl;

import java.math.BigDecimal;
import java.util.*;

public class DataBuilder implements AbstractBuilder {
    private final AccountService accountService = new AccountServiceImpl();
    private final CardServiceImpl cardService = new CardServiceImpl();

    @Override
    public void buildDataList() {

        CodeGenerator generator = new CodeGenerator() {
            @Override
            public String generateCode() {
                String code;
                List<Card> cards = cardService.getCardRepository().findAll();
                while (true) {
                    code = UUID.randomUUID().toString();
                    for (Card i : cards) {
                        if (i.getIdentCode() != null && i.getIdentCode().equals(code)) {
                        }
                    }
                    break;
                }
                return code;
            }
        };

        for (Map.Entry<String, String> entry : getKeyValueMapByBundleProperties().entrySet()) {
            Account account = new Account();

            String phoneNameProperty = entry.getKey();
            account.setPhoneNumber(phoneNameProperty);
            accountService.saveOrUpdate(account);

            if (entry.getValue().contains(";")) { // if value has two or bigger books
                List<String> cardsProperties = Arrays.asList(entry.getValue().split(";"));

                for (String i : cardsProperties) {
                    List<String> cardProperties = Arrays.asList(i.split("#"));
                    String owner = cardProperties.get(0);
                    String balance = cardProperties.get(1);
                    Card card = new Card();
                    card.setBalance(new BigDecimal(balance));
                    card.setOwner(owner);
                    card.setAccountId(account.getId());
                    card.setIdentCode(generator.generateCode());

                    cardService.saveOrUpdate(card);
                }
            } else {
                List<String> cardProperties = Arrays.asList(entry.getValue().split("#"));
                String owner = cardProperties.get(0);
                String balance = cardProperties.get(1);
                Card card = new Card();
                card.setBalance(new BigDecimal(balance));
                card.setOwner(owner);
                card.setAccountId(account.getId());

                cardService.saveOrUpdate(card);
            }
        }
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public CardServiceImpl getCardService() {
        return cardService;
    }
}

