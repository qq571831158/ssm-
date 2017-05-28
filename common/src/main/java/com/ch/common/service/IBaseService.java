package com.ch.common.service;

import com.ch.common.model.BaseModel;
import com.ch.pageutil.Page;

import java.util.List;

/**
 * Created by apple on 2017/5/28.
 */
public interface IBaseService<M,QM extends BaseModel> {

    void create(M customerModel);

    void update(M customerModel);

    void delete(int uuid);

    M getByUuid(int uuid);

    Page<M> getByConditionPage(QM cqm);
}
