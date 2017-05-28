package com.ch.common.service;

import com.ch.common.dao.BaseDAO;
import com.ch.common.model.BaseModel;
import com.ch.pageutil.Page;

import java.util.List;

/**
 * Created by apple on 2017/5/28.
 */
public class BaseService<M, QM extends BaseModel> implements IBaseService<M, QM> {
    private BaseDAO dao = null;

    public void setDAO(BaseDAO dao) {
        this.dao = dao;
    }

    public void create(M customerModel) {
        dao.create(customerModel);
    }

    public void update(M customerModel) {
        dao.update(customerModel);
    }

    public void delete(int uuid) {
        dao.delete(uuid);
    }

    public M getByUuid(int uuid) {
        return (M) dao.getByUuid(uuid);
    }

    public Page<M> getByConditionPage(QM cqm) {
        List<M> list = dao.getByConditionPage(cqm);
        cqm.getPage().setResult(list);
        return cqm.getPage();
    }
}
