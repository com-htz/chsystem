package com.htz.chsystem.web.admin.service.impl;

import com.htz.chsystem.commons.dto.BaseResult;
import com.htz.chsystem.commons.dto.PageInfo;
import com.htz.chsystem.commons.validator.BeanValidator;
import com.htz.chsystem.domain.TbWorker;
import com.htz.chsystem.web.admin.dao.TbWorkerDao;
import com.htz.chsystem.web.admin.service.TbWorkerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UserService实现类
 * <p>Title: TbWorkerServiceImpl</p>
 * <p>Description: </p>
 *
 * @author EnergyFiled
 * @version 1.0.0
 */

@Service
@Transactional(readOnly = true)
public class TbWorkerServiceImpl implements TbWorkerService {

    @Resource
    private TbWorkerDao tbWorkerDao;


    @Override
    public List<TbWorker> selectAll() {
        return tbWorkerDao.selectAll();
    }


    @Override
    @Transactional(readOnly = false)
    public BaseResult save(TbWorker tbWorker) {
        // 验证用户表单信息
        String validator = BeanValidator.validator(tbWorker);
        // 验证不通过
        if (validator != null) {
            return BaseResult.fail(validator);
        }
        // 通过验证
        else {
            tbWorker.setUpdated(new Date());
            // 新增用户
            if (tbWorker.getId() == null) {
                // 密码需要加密处理
                tbWorker.setPassword(DigestUtils.md5DigestAsHex(tbWorker.getPassword().getBytes()));
                tbWorker.setCreated(new Date());
                tbWorkerDao.insert(tbWorker);
            }
            // 编辑用户
            else {
                // 编辑用户时如果没有输入密码则沿用原来的密码
                if (StringUtils.isBlank(tbWorker.getPassword())) {
                    TbWorker oldTbWorker = getById(tbWorker.getId());
                    tbWorker.setPassword(tbWorker.getPassword());
                } else {
                    // 验证密码是否符合规范，密码长度介于 6 - 20 位之间
                    if (StringUtils.length(tbWorker.getPassword()) < 6 || StringUtils.length(tbWorker.getPassword()) > 20) {
                        return BaseResult.fail("密码长度必须介于 6 - 20 位之间");
                    }
                    // 设置密码加密
                    tbWorker.setPassword(DigestUtils.md5DigestAsHex(tbWorker.getPassword().getBytes()));
                }
                update(tbWorker);
            }
            return BaseResult.success("保存用户信息成功");
        }
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Long id) {
        tbWorkerDao.delete(id);
    }

    @Override
    public TbWorker getById(Long id) {
        return tbWorkerDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(TbWorker tbWorker) {
        tbWorkerDao.update(tbWorker);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteMulti(String[] ids) {
        tbWorkerDao.deleteMulti(ids);
    }

    @Override
    public PageInfo<TbWorker> page(int start, int length, int draw, TbWorker tbWorker) {
        int count = count(tbWorker);
        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);
        params.put("pageParams", tbWorker);
        PageInfo<TbWorker> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(tbWorkerDao.page(params));
        return pageInfo;
    }

    @Override
    public int count(TbWorker tbWorker) {
        return tbWorkerDao.count(tbWorker);
    }

    @Override
    public TbWorker login(String phone, String password) {
        TbWorker tbWorker = tbWorkerDao.getByPhone(phone);
        if (tbWorker != null){
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
            if (md5Password.equals(tbWorker.getPassword())){
                return tbWorker;
            }
        }
        return null;
    }
}
