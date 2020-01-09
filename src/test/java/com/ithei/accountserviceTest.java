package com.ithei;

import com.pojo.AccountDO;
import com.service.AccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//使用junit 测试
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class accountserviceTest {

    @Autowired
  private AccountService accountService ;


    @Test
    public void testFindAll() {


//        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //AccountService accountService = (AccountService) ac.getBean("accountService",AccountService.class);
        List<AccountDO> allAccount = accountService.findAllAccount();
        for (AccountDO accountDO : allAccount) {
            System.out.println(accountDO);

        }

    }
    @Test
    public void testFindOne() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountService accountService = (AccountService) ac.getBean("accountService",AccountService.class);
       AccountDO allAccount = accountService.findAccountById(1);

            System.out.println(allAccount);


    }


    @Test
    public void testUpdate() {
        AccountDO accountDO = new AccountDO();
        accountDO.setName("测试");
        accountDO.setMoney("888888888");
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountService accountService = (AccountService) ac.getBean("accountService",AccountService.class);

         accountService.saveAccout(accountDO);




    }
    @Test
    public void testtransfer() {
//        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
      //  ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
      //  AccountService accountService = (AccountService) ac.getBean("accountService",AccountService.class);
        accountService.transfer("aaa","bbb",100);
    }
}
