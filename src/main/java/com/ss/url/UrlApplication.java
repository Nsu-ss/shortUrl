package com.ss.url;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.ss.url.dao")
public class UrlApplication {

    public static void main(String[] args) {
        SpringApplication.run(UrlApplication.class, args);
    }

}
