package com.htz.chsystem.web.admin.service;

import com.htz.chsystem.commons.dto.BaseResult;
import com.htz.chsystem.commons.dto.PageInfo;
import com.htz.chsystem.domain.TbTeam;

import java.util.List;

/**
 * 
 * <p>Title: TbTeamService</p>
 * <p>Description: 班级服务层抽象类</p>
 *
 * @author EnergyFiled
 * @version 1.0.0
 * @date 17:47 2020/3/24 
 */

public interface TbTeamService {
    /**
     * 查询全部
     * @return
     */
    List<TbTeam> selectAll();

    /**
     * 保存信息
     * @param tbTeam
     * @return
     */
    BaseResult save(TbTeam tbTeam);

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
    TbTeam getById(Long id);

    /**
     * 更新信息
     * @param tbTeam
     */
    void update(TbTeam tbTeam);


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
    PageInfo<TbTeam> page(int start, int length, int draw, TbTeam tbTeam);

    /**
     * 查询总条数
     * @return
     */
    int count(TbTeam tbTeam);

}
