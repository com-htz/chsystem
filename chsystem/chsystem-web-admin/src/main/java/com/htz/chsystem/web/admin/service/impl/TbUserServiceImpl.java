package com.htz.chsystem.web.admin.service.impl;

import com.htz.chsystem.commons.dto.BaseResult;
import com.htz.chsystem.commons.dto.PageInfo;
import com.htz.chsystem.commons.validator.BeanValidator;
import com.htz.chsystem.domain.TbUser;
import com.htz.chsystem.web.admin.dao.TbUserDao;
import com.htz.chsystem.web.admin.service.TbUserService;
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
 * <p>Title: TbUserServiceImpl</p>
 * <p>Description: </p>
 *
 * @author EnergyFiled
 * @version 1.0.0
 */

@Service
@Transactional(readOnly = true)
public class TbUserServiceImpl implements TbUserService {

    @Resource
    private TbUserDao tbUserDao;


    @Override
    public List<TbUser> selectAll() {
        return tbUserDao.selectAll();
    }


    @Override
    @Transactional(readOnly = false)
    public BaseResult save(TbUser tbUser) {
        // 验证用户表单信息
        String validator = BeanValidator.validator(tbUser);
        // 验证不通过
        if (validator != null) {
            return BaseResult.fail(validator);
        }
        // 通过验证
        else {
            tbUser.setUpdated(new Date());
            // 新增用户
            if (tbUser.getId() == null) {
                // 密码需要加密处理
                tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
                tbUser.setCreated(new Date());
                tbUserDao.insert(tbUser);
            }
            // 编辑用户
            else {
                // 编辑用户时如果没有输入密码则沿用原来的密码
                if (StringUtils.isBlank(tbUser.getPassword())) {
                    TbUser oldTbUser = getById(tbUser.getId());
                    tbUser.setPassword(oldTbUser.getPassword());
                } else {
                    // 验证密码是否符合规范，密码长度介于 6 - 20 位之间
                    if (StringUtils.length(tbUser.getPassword()) < 6 || StringUtils.length(tbUser.getPassword()) > 20) {
                        return BaseResult.fail("密码长度必须介于 6 - 20 位之间");
                    }
                    // 设置密码加密
                    tbUser.setPassword(DigestUtils.md5DigestAsHex(tbUser.getPassword().getBytes()));
                }
                update(tbUser);
            }
            return BaseResult.success("保存用户信息成功");
        }
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Long id) {
        tbUserDao.delete(id);
    }

    @Override
    public TbUser getById(Long id) {
        return tbUserDao.getById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(TbUser tbUser) {
        tbUserDao.update(tbUser);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteMulti(String[] ids) {
        tbUserDao.deleteMulti(ids);
    }

    @Override
    public PageInfo<TbUser> page(int start, int length, int draw, TbUser tbUser) {
        int count = count(tbUser);
        Map<String, Object> params = new HashMap<>();
        params.put("start", start);
        params.put("length", length);
        params.put("pageParams", tbUser);
        PageInfo<TbUser> pageInfo = new PageInfo<>();
        pageInfo.setDraw(draw);
        pageInfo.setRecordsTotal(count);
        pageInfo.setRecordsFiltered(count);
        pageInfo.setData(tbUserDao.page(params));
        return pageInfo;
    }

    @Override
    public int count(TbUser tbUser) {
        return tbUserDao.count(tbUser);
    }

    @Override
    public TbUser login(String phone, String password) {
        TbUser tbUser = tbUserDao.getByPhone(phone);
        if (tbUser != null){
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
            if (md5Password.equals(tbUser.getPassword())){
                return tbUser;
            }
        }
        return null;
    }
}
