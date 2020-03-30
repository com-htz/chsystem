package com.htz.chsystem.web.admin.service;

import com.htz.chsystem.commons.dto.BaseResult;
import com.htz.chsystem.commons.dto.PageInfo;
import com.htz.chsystem.domain.TbStudent;
import com.htz.chsystem.domain.TbTeamStudent;

import java.util.List;

/**
 *
 * <p>Title: TbStudentService</p>
 * <p>Description: 服务层抽象类</p>
 *
 * @author EnergyFiled
 * @version 1.0.0
 * @date 9:48 2020/3/26
 */

public interface TbStudentService {
    /**
     * 查询全部
     * @return
     */
    List<TbStudent> selectAll();

    /**
     * 保存信息
     * @param entity
     * @return
     */
    BaseResult save(TbStudent entity);

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
    TbStudent getById(Long id);

    /**
     * 更新信息
     * @param entity
     */
    void update(TbStudent entity);


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
    PageInfo<TbStudent> page(int start, int length, int draw, TbTeamStudent entity);

    /**
     * 查询总条数
     * @return
     */
    int count(TbTeamStudent entity);
}
