package com.htz.chsystem.web.admin.dao;

import com.htz.chsystem.domain.TbTeam;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 
 * <p>Title: TbTeamDao</p>
 * <p>Description: 班级表数据访问层</p>
 *
 * @author EnergyFiled
 * @version 1.0.0
 * @date 16:36 2020/3/24 
 */

@Repository
public interface TbTeamDao {
    /**
     * 查询全部信息
     * @return
     */
    List<TbTeam> selectAll();

    /**
     * 新增
     * @param entity
     */
    void insert(TbTeam entity);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);

    /**
     * 更新信息
     * @param entity
     */
    void update(TbTeam entity);

    /**
     * 根据 ID 查询信息
     * @param id
     * @return
     */
    TbTeam getById(Long id);

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
    List<TbTeam> page(Map<String, Object> params);

    /**
     * 查询总结果数
     * @return
     */
    int count(TbTeam entity);

}
