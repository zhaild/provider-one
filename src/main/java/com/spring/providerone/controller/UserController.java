package com.spring.providerone.controller;

import com.spring.providerone.entity.User;
import com.spring.providerone.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhaild
 * @date 2020/7/3110:35 AM
 * @Description: 用户控制层
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired

    private IUserService service;

    @RequestMapping("/userList")

    public List getUserList() {

        return service.findAllUser();

    }

    @RequestMapping("/add")

    public String addUser(@RequestBody User user) {

        if (user != null) {

            service.createUser(user);

            return "success";

        } else {

            return "error";

        }

    }

    @RequestMapping("/delUser")

    public String delUser(@RequestParam String id) {

        try {

            service.delUser(id);

            return "del success";

        } catch (Exception e) {

            e.printStackTrace();

            return "del false";

        }

    }

    @RequestMapping("/updateUser")

    public String updateUser(@RequestBody User user) {

        try {

            service.updateUser(user);

            return "update success";

        } catch (Exception e) {

            e.printStackTrace();

            return "update false";

        }

    }

    //测试方法，返回服务器端口，以判断是访问哪个服务

    @Value("${server.port}")

    String port;

    @RequestMapping("/hi")

    public String home(@RequestParam(value = "name", defaultValue = "zhangsan") String name) {

        return "hi " + name + " ,i am from port:" + port;

    }

}
