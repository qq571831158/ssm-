package com.ch.customermgr.dao;

import com.ch.common.dao.BaseDAO;
import com.ch.customermgr.model.CustomerModel;
import com.ch.customermgr.model.CustomerQueryModel;
import org.springframework.stereotype.Repository;

/**
 * Created by apple on 2017/5/26.
 */
@Repository
public interface CustomerDAO extends BaseDAO<CustomerModel,CustomerQueryModel>{

}
