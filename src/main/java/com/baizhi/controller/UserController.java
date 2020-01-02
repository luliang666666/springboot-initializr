package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {
    //依赖于UserService
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("queryAll")
    public List<User> queryAll() {
        List<User> users = userService.queryAll();
        //默认通过request作用域存储数据
        return users;
    }

    /*
     * 文件上传
     * */
    @ResponseBody
    @RequestMapping("upload")
    public String upload(MultipartFile file, HttpSession session) {
        //1.获得upload的路径
        String realPath = session.getServletContext().getRealPath("/upload/img");
        //2.判断文件是否存在
        File file1 = new File(realPath);
        if (!file1.exists()) {
            file1.mkdirs();
        }
        //3.获取文件的真实名字
        String originalFilename = file.getOriginalFilename();
        //4.防止同一文件上传多次发生覆盖   拼接时间戳
        String filename = new Date().getTime() + "-" + originalFilename;
        //5.文件上传
        try {
            file.transferTo(new File(realPath, filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传成功";
    }
}
