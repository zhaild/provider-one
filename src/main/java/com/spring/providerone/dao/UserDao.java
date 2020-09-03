package com.spring.providerone.dao;

import com.spring.providerone.entity.User;

import java.util.List;

/**
 * @author zhaild
 * @date 2020/7/3110:35 AM
 * @Description: 用户持久层DAO
 */
public interface UserDao {
    /**
     * 新增用户
     *
     * @param user
     */

    void createUser(User user);

    /**
     * 查询用户列表
     *
     * @return
     */

    List findAllUser();

    /**
     * 删除用户
     *
     * @return
     */

    void delUser(String id);

    /**
     * 修改用户
     *
     * @return
     */

    void updateUser(User user);
}
