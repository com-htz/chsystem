package com.htz.chsystem.web.admin.dao;

import com.htz.chsystem.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 *用户数据访问层
 */
@Repository
public interface TbUserDao {

    /**
     * 查询全部信息
     * @return
     */
    List<TbUser> selectAll();

    /**
     * 新增
     * @param entity
     */
    void insert(TbUser entity);

    /**
     * 删除
     * @param id
     */
    void delete(Long id);

    /**
     * 更新信息
     * @param entity
     */
    void update(TbUser entity);

    /**
     * 根据 ID 查询信息
     * @param id
     * @return
     */
    TbUser getById(Long id);

    /**
     * 根据手机号查询用户信息
     * @param phone
     * @return
     */
    TbUser getByPhone(String phone);

    /**
     * 搜索
     * @param entity
     * @return
     */
    List<TbUser> search(TbUser entity);

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
    List<TbUser> page(Map<String, Object> params);

    /**
     * 查询总结果数
     * @return
     */
    int count(TbUser entity);

}
