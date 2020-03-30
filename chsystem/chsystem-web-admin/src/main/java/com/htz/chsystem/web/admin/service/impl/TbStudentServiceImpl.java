package com.htz.chsystem.web.admin.service.impl;

import com.htz.chsystem.commons.dto.BaseResult;
import com.htz.chsystem.commons.dto.PageInfo;
import com.htz.chsystem.domain.TbStudent;
import com.htz.chsystem.domain.TbTeamStudent;
import com.htz.chsystem.web.admin.dao.TbStudentDao;
import com.htz.chsystem.web.admin.service.TbStudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * <p>Title: TbStudentServiceImpl</p>
 * <p>Description: 学生服务层实现类</p>
 *
 * @author EnergyFiled
 * @version 1.0.0
 * @date 10:26 2020/3/26
 */


@Service
public class TbStudentServiceImpl implements TbStudentService {

    @Resource
    private TbStudentDao tbStudentDao;

    @Override
    public List<TbStudent> selectAll() {
        return tbStudentDao.selectAll();
    }

    @Override
    public BaseResult save(TbStudent entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public TbStudent getById(Long id) {
        return tbStudentDao.getById(id);
    }

    @Override
    public void update(TbStudent entity) {

    }

    @Override
    public void deleteMulti(String[] ids) {
        tbStudentDao.deleteMulti(ids);
    }

    /**
     *
     * @Description: 根据班级信息或学生姓名查询学生信息
     *
     * @auther: EnergyFiled
     * @date: 21:55 2020/3/30
     * @param: [start, length, draw, entity]
     * @return: com.htz.chsystem.commons.dto.PageInfo<com.htz.chsystem.domain.TbStudent>
     *
    */
    @Override
    public PageInfo<TbStudent> page(int start, int length, int draw, TbTeamStudent entity) {
        int count = count(entity);
        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);
        params.put("pageParams", entity);
        PageInfo<TbStudent> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(tbStudentDao.page(params));
        return pageInfo;
    }

    @Override
    public int count(TbTeamStudent entity) {
        return tbStudentDao.count(entity);
    }
}
