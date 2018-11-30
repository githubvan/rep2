package com.itheima.dao.impl;

import com.itheima.dao.accountDao;
import com.itheima.domain.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
 @Repository("accountDao")
public class accountDaoImpl implements accountDao {

    @Autowired
private JdbcTemplate jdbcTemplate;


    public account findonebyid(Integer id) {

            List<account> query = jdbcTemplate.query("select * from account where  id = ?", new BeanPropertyRowMapper<account>(account.class), id);

            return query.isEmpty()? null:query.get(0);

    }

     public account findByName(String name) {
         List<account> query = jdbcTemplate.query("select * from account where name=?", new BeanPropertyRowMapper<account>(account.class), name);
         if (query.isEmpty()){
             return null;
         }
         if (query.size()>1){
             throw new RuntimeException("结果集不唯一");
         }

         return query.get(0);
     }

     public void update(account account) {
        jdbcTemplate.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
     }

 }

