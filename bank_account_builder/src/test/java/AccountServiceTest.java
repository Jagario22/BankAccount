import builder.DataBuilder;
import org.junit.jupiter.api.Test;
import service.AccountService;

import static org.junit.jupiter.api.Assertions.*;


public class AccountServiceTest {
    private DataBuilder builder = new DataBuilder();
    private AccountService accountService;

    AccountServiceTest() {
        builder.buildDataList();
        accountService = builder.getAccountService();
    }

    @Test
    void findAll() {
        assertEquals(3, accountService.findAll().size());
    }

    @Test
    void findAccountByPhoneNumber() {
        assertEquals("+380685850737", accountService.findById(1L).getPhoneNumber());
        assertEquals(1L, accountService.findAccountByPhoneNumber("+380685850737").getId());
    }
}
