package com.xdd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @Auther: Lcs
 * @Date: 2020/9/5 09:24
 * @Description:
 */
@SpringBootApplication
@MapperScan("com.xdd.dao")
@ServletComponentScan
public class OrderServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class,args);
    }
}
