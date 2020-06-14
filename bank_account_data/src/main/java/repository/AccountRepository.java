package repository;

import entity.Account;

public interface AccountRepository extends AbstractRepository<Account>{
    Account findAccountByPhoneNumber(String phone);
}
