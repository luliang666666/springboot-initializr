package com.baizhi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @RestController  类中所有方法的返回值均为json
 * */
@RestController
@RequestMapping("user")
public class Controller {
    @RequestMapping("test")
    public String test() {
        return "你好！";
    }

}
