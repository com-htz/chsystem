package com.htz.chsystem.web.admin.dao;

import com.htz.chsystem.domain.TbWorker;
import org.springframework.stereotype.Repository;

/**
 * 用户数据访问层
 * <p>Title: TbWorkerDao</p>
 * <p>Description: </p>
 *
 * @author EnergyFiled
 * @version 1.0.0
 */

@Repository
public interface TbWorkerDao extends BaseDao<TbWorker> {
    /**
     * 根据手机号查询用户信息
     * @param phone
     * @return
     */
    TbWorker getByPhone(String phone);

}
