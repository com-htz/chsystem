package com.htz.chsystem.web.admin.dao;

import com.htz.chsystem.domain.TbWorker;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 用户数据访问层
 * <p>Title: TbWorkerDao</p>
 * <p>Description: </p>
 *
 * @author EnergyFiled
 * @version 1.0.0
 */

@Repository
public interface TbWorkerDao {

    /**
     * 查询全部信息
     * @return
     */
    List<TbWorker> selectAll();

    /**
     * 新增
     * @param entity
     */
    void insert(TbWorker entity);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);

    /**
     * 更新信息
     * @param entity
     */
    void update(TbWorker entity);

    /**
     * 根据 ID 查询信息
     * @param id
     * @return
     */
    TbWorker getById(Long id);

    /**
     * 根据手机号查询用户信息
     * @param phone
     * @return
     */
    TbWorker getByPhone(String phone);

    /**
     * 批量删除
     * @param ids
     */
    void deleteMulti(String[] ids);

    /**
     * 分页查询
     * @param params 两个参数， start/记录开始位置, length/每页记录数
     * @return
     */
    List<TbWorker> page(Map<String, Object> params);

    /**
     * 查询总结果数
     * @return
     */
    int count(TbWorker entity);

}
