package com.dao.impl;

import com.dao.AccountDao;
import com.pojo.AccountDO;
import com.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Repository
public class AccountDaoImpl implements AccountDao {


      private QueryRunner runner;

       private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }



    public void saveAccout(AccountDO accountDO) {
        try {
            runner.update(connectionUtils.getThreadLocalConn(),"insert into account(name,money) values (?,?)",accountDO.getName(),accountDO.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public AccountDO findAccountById(Integer id) {
        try {
            return runner.query("select * from account where id =?",new BeanHandler<AccountDO>(AccountDO.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException("异常");
        }
    }

    public List<AccountDO> findAllAccount() {
        try {
            return runner.query(connectionUtils.getThreadLocalConn(),"select * from account",new BeanListHandler<AccountDO>(AccountDO.class));
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
            throw  new RuntimeException("异常");
        }
    }

    public void updateAccount(AccountDO accountDO) {
        try {
            runner.update(connectionUtils.getThreadLocalConn(),"update account set name=?,money =? where id =?",accountDO.getName(),accountDO.getMoney(),accountDO.getId());
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void deleteAccount(Integer id) {
        try {
            runner.update(connectionUtils.getThreadLocalConn(),"delete from account  where id =?",id);
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public AccountDO findAccountByName(String accountName) {
        try {
            List<AccountDO>  accountDoList =runner.query(connectionUtils.getThreadLocalConn(),"select * from account where name =?",new BeanListHandler<AccountDO>(AccountDO.class),accountName);
                  if (accountDoList ==null){
                      return null;
                  }else {
                      if (accountDoList.size()>1){
                          throw  new RuntimeException("数据不唯一，有异常");
                      }
                  }
                  return  accountDoList.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
            throw  new RuntimeException("异常");
        }
    }
}
