package com.cj.shopback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.cj.shopback.mapper")
public class ShopBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopBackApplication.class, args);
    }

}
