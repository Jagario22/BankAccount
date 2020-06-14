package service;

import entity.Account;

public interface AccountService extends AbstractService<Account>{

    Account findAccountByPhoneNumber(String phone);
}
