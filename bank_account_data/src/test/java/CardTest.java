import entity.Account;
import entity.Card;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    private Account account1 = new Account();
    private Card card1 = new Card();
    private Account account2 = new Account();
    private Card card2 = new Card();

    @Test
    void transferMethod() {
        account1.setPhoneNumber("+380685850737");
        account1.setId(1L);

        card1.setOwner("Vlada Volska");
        card1.setIdentCode("0110");
        card1.setAccountId(1L);
        card1.setBalance(new BigDecimal(100));
        card1.setId(1L);

        account2.setPhoneNumber("+380685950737");
        account2.setId(2L);

        card2.setOwner("Clara Hendrix");
        card2.setIdentCode("1001");
        card2.setAccountId(2L);
        card2.setBalance(new BigDecimal(100));
        card2.setId(2L);

        card1.transferToCard(card2, new BigDecimal(100));
        assertEquals(new BigDecimal(200), card2.getBalance());
        assertEquals(new BigDecimal(0), card1.getBalance());
    }

    @Test
    void addMoneyMethod() {

        account1.setPhoneNumber("+380685850737");
        account1.setId(1L);

        card1.setOwner("Vlada Volska");
        card1.setIdentCode("0110");
        card1.setAccountId(1L);
        card1.setBalance(new BigDecimal(100));
        card1.setId(1L);

        card1.addMoney(new BigDecimal(100));
        assertEquals(new BigDecimal(200), card1.getBalance());
    }

    @Test
    void withdrawMoney() {

        account1.setPhoneNumber("+380685850737");
        account1.setId(1L);

        card1.setOwner("Vlada Volska");
        card1.setIdentCode("0110");
        card1.setAccountId(1L);
        card1.setBalance(new BigDecimal(100));
        card1.setId(1L);

        card1.withdrawMoney(new BigDecimal(100));
        assertEquals(new BigDecimal(0), card1.getBalance());
    }

}
