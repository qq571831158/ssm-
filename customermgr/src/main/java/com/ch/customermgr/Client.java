package com.ch.customermgr;

import com.ch.customermgr.dao.CustomerDAO;
import com.ch.customermgr.model.CustomerModel;
import com.ch.customermgr.model.CustomerQueryModel;
import com.ch.customermgr.service.ICustomerService;
import com.ch.pageutil.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by apple on 2017/5/28.
 */
@Service
@Transactional
public class Client {
    @Autowired
    private ICustomerService s = null;

    public ICustomerService getS(){
        return s;
    }

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        Client c = (Client)ac.getBean("client");
        CustomerModel customerModel = new CustomerModel();
        customerModel.setCustomerId("cheng");
        customerModel.setPwd("123456");
        customerModel.setShowName("筱橙子丶");
        customerModel.setTrueName("程恒");
        customerModel.setRegisterTime("2017-05-28");
        CustomerQueryModel customerQueryModel = new CustomerQueryModel();
        customerQueryModel.getPage().setNowPage(1);
        customerQueryModel.getPage().setPageShow(1);
        Page<CustomerModel> p = c.getS().getByConditionPage(customerQueryModel);
        System.out.println(customerQueryModel.getPage());
        System.out.println("list----->"+p);
    }
}
