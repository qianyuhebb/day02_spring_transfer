package com.controller;


import com.dao.AccountDao;
import com.factory.BeanFactory;
import com.service.AccountService;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {


    /**
     *   获取IOC容器 ，
     *   根据id 获取bean
     * @param args
     */
    public static void main(String[] args) {
            //立即加载的方式     单例情况下使用      更多的使用这种情况
//        ApplicationContext  ac =new ClassPathXmlApplicationContext("bean.xml");
//        AccountService as = (AccountService) ac.getBean("accountService");
//        AccountDao as2 = ac.getBean("accountDao", AccountDao.class);




         //懒加载的方式   多例情况下使用
    /*    Resource resource = new ClassPathResource("bean.xml");
        XmlBeanFactory factory =new XmlBeanFactory(resource);
        AccountService as = (AccountService) factory.getBean("accountService");
        AccountDao as2 = factory.getBean("accountDao", AccountDao.class);


        System.out.println(as);
        System.out.println(as2);
        as.saveAccout();
        as2.saveAccount();*/
    }

}
