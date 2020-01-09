package com.service;

import com.pojo.AccountDO;

import java.util.List;

public interface AccountService {

    void saveAccout(AccountDO accountDO);

    AccountDO findAccountById( Integer id);

   List<AccountDO> findAllAccount();


    void updateAccount(AccountDO accountDO);

    void  deleteAccount(Integer id);

    void transfer(String sourceName,String targetName , Integer money);
}
