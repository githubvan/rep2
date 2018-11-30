package TT;


import com.itheima.config.springconfig;
import com.itheima.domain.account;
import com.itheima.service.accountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.util.List;

public class T1 {
    @Test
    public void name() {
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(springconfig.class);
        accountService accountService = applicationContext.getBean("accountServiceImpl_proxy", accountService.class);
        accountService.transfer("aaa","bbb",100);

    }
}
