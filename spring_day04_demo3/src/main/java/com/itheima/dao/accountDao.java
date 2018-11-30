package com.itheima.dao;

import com.itheima.domain.account;

import java.util.List;

public interface accountDao {

     account findonebyid(Integer id);

    public  account findByName(String name);

    public void update(account account);


}
