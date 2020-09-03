package com.spring.providerone.service;

import com.spring.providerone.entity.User;
import java.util.List;

/**
 * @author zhaild
 * @date 2020/7/3110:35 AM
 * @Description: 用户业务层接口
 */
public interface IUserService {
    /**
     * 新增用户
     *
     * @param user
     */

    public void createUser(User user);

    /**
     * 查询用户列表
     *
     * @return
     */

    public List findAllUser();

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
