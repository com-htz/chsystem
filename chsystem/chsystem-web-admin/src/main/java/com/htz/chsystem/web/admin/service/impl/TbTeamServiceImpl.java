package com.htz.chsystem.web.admin.service.impl;

import com.htz.chsystem.commons.dto.BaseResult;
import com.htz.chsystem.commons.dto.PageInfo;
import com.htz.chsystem.commons.validator.BeanValidator;
import com.htz.chsystem.domain.TbTeam;
import com.htz.chsystem.web.admin.dao.TbTeamDao;
import com.htz.chsystem.web.admin.service.TbTeamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * <p>Title: TbTeamServiceImpl</p>
 * <p>Description: 班级服务层实现类</p>
 *
 * @author EnergyFiled
 * @version 1.0.0
 * @date 17:50 2020/3/24
 */

@Service
public class TbTeamServiceImpl implements TbTeamService {
    
    @Resource
    private TbTeamDao tbTeamDao;
    
    @Override
    public List<TbTeam> selectAll() {
        return tbTeamDao.selectAll();
    }

    /**
     *
     * @Description: 保存班级信息
     * 
     * @auther: EnergyFiled
     * @date: 22:41 2020/3/24 
     * @param: [tbTeam]
     * @return: BaseResult
     *
    */
    @Override
    public BaseResult save(TbTeam tbTeam) {
        //验证班级信息表单
        String validator = BeanValidator.validator(tbTeam);
        //验证失败
        if (validator != null){
            return BaseResult.fail(validator);
        }
        //通过验证
        else {
            //判断是否是新增班级
            if (tbTeam.getId() == null){
                tbTeamDao.insert(tbTeam);
            }
            //更新班级信息
            else {
                tbTeamDao.update(tbTeam);
            }
            return BaseResult.success("保存班级信息成功");
        }

    }

    /**
     *
     * @Description: 删除班级
     * TODO 待完善
     * @auther: EnergyFiled
     * @date: 22:44 2020/3/24
     * @param: [id]
     * @return: void
     *
    */
    @Override
    public void delete(Long id) {
        tbTeamDao.delete(id);
    }

    @Override
    public TbTeam getById(Long id) {
        return tbTeamDao.getById(id);
    }

    @Override
    public void update(TbTeam tbTeam) {
        tbTeamDao.update(tbTeam);
    }

    @Override
    public void deleteMulti(String[] ids) {
        tbTeamDao.deleteMulti(ids);
    }

    /**
     *
     * @Description: 分页查询班级
     *
     * @auther: EnergyFiled
     * @date: 22:44 2020/3/24
     * @param: [start, length, draw, tbTeam]
     * @return: TbTeam
     *
    */
    @Override
    public PageInfo<TbTeam> page(int start, int length, int draw, TbTeam tbTeam) {
        int count = count(tbTeam);
        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);
        params.put("pageParams", tbTeam);
        PageInfo<TbTeam> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(tbTeamDao.page(params));
        return pageInfo;
    }

    @Override
    public int count(TbTeam tbTeam) {
        return tbTeamDao.count(tbTeam);
    }
}
