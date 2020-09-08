package com.xdd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@MapperScan("com.xdd.dao")
@ServletComponentScan
public class CollectServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CollectServiceApplication.class,args);
    }
}

