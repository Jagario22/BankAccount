package service.impl;

import entity.Account;
import repository.AccountRepository;
import repository.impl.AccountRepositoryImpl;
import service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository = new AccountRepositoryImpl();

    @Override
    public Account findAccountByPhoneNumber(String phone) {
        return accountRepository.findAccountByPhoneNumber(phone);
    }

    @Override
    public void saveOrUpdate(Account account) {
        if (account.getId() == null) {
            long id = findAll().size();
            account.setId(++id);
            accountRepository.save(account);
        } else {
            accountRepository.update(account);
        }
    }

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public void remove(Long id) {
        accountRepository.remove(id);
    }
}
