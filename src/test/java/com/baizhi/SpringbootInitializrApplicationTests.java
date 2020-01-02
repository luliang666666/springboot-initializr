package com.baizhi;


import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = SpringbootInitializrApplication.class)
@RunWith(SpringRunner.class)
public class SpringbootInitializrApplicationTests {
    @Autowired
    private UserDao userDao;

    @Test
    public void contextLoads() {
        List<User> users = userDao.queryAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

}
