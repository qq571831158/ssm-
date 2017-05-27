package com.ch.customermgr.dao;

import com.ch.customermgr.model.CustomerModel;
import com.ch.customermgr.model.CustomerQueryModel;

import java.util.List;

/**
 * Created by apple on 2017/5/26.
 */
public interface CustomerDAO {


    void create(CustomerModel customerModel);

    void update(CustomerModel customerModel);

    void delete(int uuid);

    CustomerModel getByUuid(int uuid);

    List<CustomerModel> getByCondition(CustomerQueryModel cqm);

}
