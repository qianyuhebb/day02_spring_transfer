package com.dao;

import com.pojo.AccountDO;

import java.util.List;

public interface    AccountDao {

    void saveAccout(AccountDO accountDO);

    AccountDO findAccountById(Integer id);

    List<AccountDO> findAllAccount();


    void updateAccount(AccountDO accountDO);

    void  deleteAccount(Integer id);

    AccountDO findAccountByName(String accountName);

}
