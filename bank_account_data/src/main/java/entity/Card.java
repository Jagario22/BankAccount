package entity;

import java.math.BigDecimal;

public class Card extends AbstractData<Card> {
    private String owner;
    private Long cardAccountId;
    private BigDecimal balance;
    private String identCode;
    private Operation operation = new Operation();

    private class Operation {
        private void transfer(Card card, BigDecimal money) {
            if (money.compareTo(new BigDecimal(0)) <= 0) {
                System.out.println("Error. Amount cannot be negative or equal to zero");
            } else if (balance.compareTo(money) < 0) {
                System.out.println("Not enough money on the card");
            } else {
                balance = balance.subtract(money);
                card.setBalance(card.getBalance().add(money));
            }
        }

        private void addMoney(BigDecimal money) {
            if (money.compareTo(new BigDecimal(0)) <= 0) {
                System.out.println("Error. Amount cannot be negative or equal to zero");
            } else {
                balance = balance.add(money);
            }
        }

        private void withdrawMoney(BigDecimal money) {
            if (money.compareTo(new BigDecimal(0)) <= 0) {
                System.out.println("Error. Amount cannot be negative or equal to zero");
            } else {
                balance = balance.subtract(money);
            }
        }
    }

    public void transferToCard(Card card, BigDecimal money) {
        operation.transfer(card, money);
    }

    public void addMoney(BigDecimal money) {
        operation.addMoney(money);
    }

    public void withdrawMoney(BigDecimal money) {
        operation.withdrawMoney(money);
    }

    public Long getAccountId() {
        return cardAccountId;
    }

    public void setAccountId(Long accountId) {
        this.cardAccountId = accountId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getIdentCode() {
        return identCode;
    }

    public void setIdentCode(String identCode) {
        this.identCode = identCode;
    }

    public Long getCardAccountId() {
        return cardAccountId;
    }

    public void setCardAccountId(Long cardAccountId) {
        this.cardAccountId = cardAccountId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return owner + " " + "\n Balance: " + balance;
    }

}
