package com.itheima.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.itheima")
@Import({Jdbcconfig.class,transcationconfig.class})  //连接数据库相关的类
@PropertySource("classpath:jdbcConfig.properties")
@EnableTransactionManagement
public class springconfig {

}
