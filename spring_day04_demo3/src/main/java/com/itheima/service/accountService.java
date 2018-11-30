package com.itheima.service;

import com.itheima.domain.account;

import java.util.List;

public interface accountService {

    account findonebyid(Integer id);

    void transfer(String sourceName,String targetName,double money);

}
