package com.factory;


import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

public class BeanFactory {


    private    static Properties props;
    private    static HashMap<String,Object> beans;

    static {
        try {
           props = new Properties();

           InputStream is = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(is);
          Enumeration<Object> keys = props.keys();
            //实现单例的写法
            beans = new HashMap<String, Object>();
          while (keys.hasMoreElements()){
            String key = keys.nextElement().toString();
               String beanPath = props.getProperty(key);
               Object value = Class.forName(beanPath).newInstance();
                beans.put(key,value);
           }




        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public static Object getBean(String beanName){

        return beans.get(beanName);
    }


 /*
    public static Object getBean(String beanName){
        System.out.println(beanName);
        Object bean =null;
        System.out.println(props);
        try {
            String beanPath = props.getProperty(beanName);
            System.out.println(beanPath);
            bean = Class.forName(beanPath).newInstance();
        } catch (Exception e) {
           e.printStackTrace();
            e.getMessage();

        }
        return bean;
    }*/
}
