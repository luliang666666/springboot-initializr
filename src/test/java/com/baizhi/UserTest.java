package com.baizhi;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)  //测试时启动容器
@SpringBootTest(classes = SpringbootInitializrApplication.class)
@Slf4j
public class UserTest {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;

    @Test
    public void test() {
        List<User> users = userDao.queryAll();
        for (User user : users) {
            log.info("this is error{}", user);
        }
        List<User> users1 = userService.queryAll();
        for (User user : users1) {
            log.info("this is error{}", user);

        }
    }
}
