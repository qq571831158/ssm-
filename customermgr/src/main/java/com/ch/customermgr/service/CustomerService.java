package com.ch.customermgr.service;

import com.ch.common.service.BaseService;
import com.ch.customermgr.dao.CustomerDAO;
import com.ch.customermgr.model.CustomerModel;
import com.ch.customermgr.model.CustomerQueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by apple on 2017/5/28.
 */
@Service
@Transactional
public class CustomerService extends BaseService<CustomerModel,CustomerQueryModel> implements ICustomerService  {
    private CustomerDAO dao = null;
    @Autowired
    private void setDao(CustomerDAO dao ){
        this.dao = dao;
        super.setDAO(dao);
    }

}
