package com.baizhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
 * 扫描dao
 * */
@MapperScan("com.baizhi.dao")
public class SpringbootInitializrApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootInitializrApplication.class, args);
        system.out.println("666666");
	System.out.println("88888888");
    }

}
