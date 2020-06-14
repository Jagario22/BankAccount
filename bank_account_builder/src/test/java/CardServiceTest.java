import builder.DataBuilder;
import org.junit.jupiter.api.Test;
import service.CardService;


import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


public class CardServiceTest {
    private DataBuilder builder = new DataBuilder();
    private CardService cardService;

    CardServiceTest() {
        builder.buildDataList();
        cardService = builder.getCardService();
    }

    @Test
    void findAll() {
        assertEquals(5, cardService.findAll().size());
    }

    @Test
    void findAllAccountCardsByAccountId() {
        assertEquals(2, cardService.findAllAccountCardsByAccountId(1L).size());
    }

    @Test
    void findAllCardsByOwner() {
        assertEquals(2, cardService.findAllCardsByOwner("James_Holding").size());
    }

    @Test
    void findById() {
        assertEquals(new BigDecimal(5000), cardService.findById(1L).getBalance());
        assertEquals("James_Holding", cardService.findById(1L).getOwner());
    }
}
