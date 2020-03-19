package com.htz.chsystem.web.admin.service;

import com.htz.chsystem.commons.dto.BaseResult;
import com.htz.chsystem.commons.dto.PageInfo;
import com.htz.chsystem.domain.TbUser;

import java.util.List;

public interface TbUserService {
    /**
     * 查询全部
     * @return
     */
    List<TbUser> selectAll();

    /**
     * 保存信息
     * @param tbUser
     * @return
     */
    BaseResult save(TbUser tbUser);

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
    TbUser getById(Long id);

    /**
     * 更新信息
     * @param tbUser
     */
    void update(TbUser tbUser);


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
    PageInfo<TbUser> page(int start, int length, int draw, TbUser tbUser);

    /**
     * 查询总条数
     * @return
     */
    int count(TbUser tbUser);

    /**
     * 登录
     * @param phone
     * @param password
     * @return
     */
    TbUser login(String phone, String password);
}
