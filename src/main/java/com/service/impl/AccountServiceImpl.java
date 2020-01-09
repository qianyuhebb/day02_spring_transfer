package com.service.impl;

import com.dao.AccountDao;
import com.factory.BeanFactory;
import com.pojo.AccountDO;
import com.service.AccountService;
import com.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("accountService")
public class AccountServiceImpl implements AccountService {

//    accountDaoImpl accountDao = new accountDaoImpl();
      /* int i =1;*/


    private AccountDao accountDao;


    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void saveAccout(AccountDO accountDO) {
        accountDao.saveAccout(accountDO);
    }



    public AccountDO findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    public List<AccountDO> findAllAccount() {


        try {

         //   transactionManager.beginTransaction();
             List<AccountDO>  accountDO = accountDao.findAllAccount();
         //   transactionManager.commit();
            return accountDO;
        } catch (Exception e) {
          //  transactionManager.rollback();
            e.printStackTrace();
            throw new RuntimeException("操作失败");
        }finally {
          //  transactionManager.release();
        }
    }

    public void updateAccount(AccountDO accountDO) {

        try {

        //    transactionManager.beginTransaction();
            accountDao.updateAccount(accountDO);
         //   transactionManager.commit();

        } catch (Exception e) {
           // transactionManager.rollback();
            e.printStackTrace();
            throw new RuntimeException("操作失败");
        }finally {
           // transactionManager.release();
        }

    }

    public void deleteAccount(Integer id) {
               accountDao.deleteAccount(id);
    }


    public void transfer(String sourceName, String targetName, Integer money) {

        try {

            transactionManager.beginTransaction();
            AccountDO source = accountDao.findAccountByName(sourceName);

            AccountDO target = accountDao.findAccountByName(targetName);

            source.setMoney(String.valueOf((Integer.parseInt(source.getMoney())-money)));
            target.setMoney(String.valueOf((Integer.parseInt(target.getMoney())+money)));
            accountDao.updateAccount(source);
            int i =1/0;
            accountDao.updateAccount(target);
           transactionManager.commit();

        } catch (Exception e) {
            e.getMessage();
           transactionManager.rollback();
            e.printStackTrace();
            throw new RuntimeException("操作失败");
        }finally {
           transactionManager.release();
        }

    }
}
