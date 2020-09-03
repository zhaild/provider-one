package com.spring.providerone.service.impl;

import com.spring.providerone.dao.UserDao;
import com.spring.providerone.entity.User;
import com.spring.providerone.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhaild
 * @date 2020/7/3110:37 AM
 * @Description: 用户层实现类
 */
@Service
@Component
public class UserServiceImpl implements IUserService {
    @Autowired

    public UserDao userDao;

    @Override

    public void createUser(User user) {

        userDao.createUser(user);

    }

    @Override

    public List findAllUser() {

        //先判断key值是否存在，如果存在直接获取value值返回；
        //若不存在，则访问数据库，获取到数据之后，再放入redis缓存，并设置失效时间
        return userDao.findAllUser();

    }

    @Override

    public void delUser(String id) {
        userDao.delUser(id);
    }

    @Override

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

}
