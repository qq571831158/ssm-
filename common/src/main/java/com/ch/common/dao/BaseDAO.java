package com.ch.common.dao;

import java.util.List;

/**
 * Created by apple on 2017/5/28.
 */
public interface BaseDAO<M,QM> {

    void create(M customerModel);

    void update(M customerModel);

    void delete(int uuid);

    M getByUuid(int uuid);

    List<M> getByConditionPage(QM cqm);
}
