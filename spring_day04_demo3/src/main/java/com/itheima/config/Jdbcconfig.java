package com.itheima.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class Jdbcconfig  {
    @Value("${jdbc.driver}")
    private String  driverclass;

    @Value("${jdbc.url}")
    private String  jdbcurl;

    @Value("${jdbc.username}")
    private String  user;

    @Value("${jdbc.password}")
    private String  password;
    @Bean(name = "JdbcTemplate")
    @Scope("prototype")
    public JdbcTemplate getJdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource cp=new DriverManagerDataSource();
        try {
            cp.setDriverClassName(driverclass);
            cp.setUrl(jdbcurl);
            cp.setUsername(user);
            cp.setPassword(password);
            return cp;
        } catch (Exception e) {
            throw new RuntimeException(e) ;
        }
    }
}
