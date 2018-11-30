package com.itheima.service.impl;

import com.itheima.dao.accountDao;
import com.itheima.domain.account;
import com.itheima.service.accountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("accountServiceImpl_proxy")
@Transactional(propagation = Propagation.SUPPORTS,readOnly =  true)
public class accountServiceImpl_proxy implements accountService {

        @Autowired
     private accountDao accountDao;

     public void setAccountDao(accountDao accountDao) {
        this.accountDao = accountDao;
    }


    public account findonebyid(Integer id) {
            account findonebyid = accountDao.findonebyid(id);
            return findonebyid;
    }

@Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void transfer(String sourceName, String targetName, double money) {
            account source = accountDao.findByName(sourceName);
            account target = accountDao.findByName(targetName);
            source.setMoney(source.getMoney()-money);
            target.setMoney(target.getMoney()+money);
            accountDao.update(source);
           //int x=1/0;
            accountDao.update(target);

    }
}
