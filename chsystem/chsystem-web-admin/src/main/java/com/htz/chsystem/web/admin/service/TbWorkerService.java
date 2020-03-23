package com.htz.chsystem.web.admin.service;

import com.htz.chsystem.commons.dto.BaseResult;
import com.htz.chsystem.commons.dto.PageInfo;
import com.htz.chsystem.domain.TbWorker;

import java.util.List;

/**
 * 用户service抽象类
 * <p>Title: TbWorkerService</p>
 * <p>Description: </p>
 *
 * @author EnergyFiled
 * @version 1.0.0
 */

public interface TbWorkerService {
    /**
     * 查询全部
     * @return
     */
    List<TbWorker> selectAll();

    /**
     * 保存信息
     * @param tbUser
     * @return
     */
    BaseResult save(TbWorker tbUser);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);

    /**
     * 根据 ID 获取信息
     * @param id
     * @return
     */
    TbWorker getById(Long id);

    /**
     * 更新信息
     * @param tbUser
     */
    void update(TbWorker tbUser);


    /**
     * 批量删除
     * @param ids
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     * @param start
     * @param length
     * @return
     */
    PageInfo<TbWorker> page(int start, int length, int draw, TbWorker tbUser);

    /**
     * 查询总条数
     * @return
     */
    int count(TbWorker tbUser);

    /**
     * 登录
     * @param phone
     * @param password
     * @return
     */
    TbWorker login(String phone, String password);
}
