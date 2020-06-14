package repository.impl;

import entity.Account;
import repository.AccountRepository;

import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryImpl implements AccountRepository {

    private List<Account> accountList = new ArrayList<Account>();

    @Override
    public Account findAccountByPhoneNumber(String phone) {
        for (Account acc: accountList)
        {
            if (acc.getPhoneNumber().equals(phone))
                return acc;

        }
        return null;
    }

    @Override
    public void save(Account account) {
        accountList.add(account);

    }

    @Override
    public Account findById(Long id) {
        for (Account acc: accountList) {
            if (acc.getId().equals(id))
                return acc;
        }
        return null;
    }

    @Override
    public List<Account> findAll() {
        return accountList;
    }

    @Override
    public void update(Account account) {
        for (Account acc: accountList)
        {
            if (account.getId().equals(acc.getId()))
            {
                acc.setPhoneNumber(account.getPhoneNumber());
            }
        }
    }

    @Override
    public void remove(Long id) {
        for (int i = 0; i < accountList.size(); i++)
        {
            if (accountList.get(i).getId().equals(id))
            {
                accountList.remove(i);
                return;
            }
        }

    }

    public List<Account> getAccounts() {
        return accountList;
    }

    public void setAccounts(List<Account> accounts) {
        this.accountList = accounts;
    }
}
