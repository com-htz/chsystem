package com.htz.chsystem.web.admin.dao;

import java.util.List;
import java.util.Map;

/**
 *
 * <p>Title: BaseDao</p>
 * <p>Description: Dao层基类</p>
 *
 * @author EnergyFiled
 * @version 1.0.0
 */

public interface BaseDao<T> {

    /**
     * 查询全部信息
     * @return
     */
    List<T> selectAll();

    /**
     * 新增
     * @param entity
     */
    void insert(T entity);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);

    /**
     * 更新信息
     * @param entity
     */
    void update(T entity);

    /**
     * 根据 ID 查询信息
     * @param id
     * @return
     */
    T getById(Long id);

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
    List<T> page(Map<String, Object> params);

    /**
     * 查询总结果数
     * @return
     */
    int count(T entity);
}
