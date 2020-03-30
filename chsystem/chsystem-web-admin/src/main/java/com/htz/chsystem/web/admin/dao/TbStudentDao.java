package com.htz.chsystem.web.admin.dao;


import com.htz.chsystem.domain.TbStudent;
import com.htz.chsystem.domain.TbTeamStudent;

/**
 *
 * <p>Title: TbStudentDao</p>
 * <p>Description: tbStudent数据访问层</p>
 *
 * @author EnergyFiled
 * @version 1.0.0
 */

public interface TbStudentDao extends BaseDao<TbStudent> {

    int count(TbTeamStudent entity);

}
