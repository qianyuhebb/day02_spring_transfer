package config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 *   该类是一个配置类，和bean.xml 的作用一样
 *
 * @import  指定其他配置类的字节码，引入其他配置
 */

//@Configuration     //知道当前类是一个配置类
@ComponentScan(basePackages = "com")    //包扫描的注解
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbc.properties")
public class SpringConfiguration {



}
