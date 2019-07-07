package com.gblfy.springboot.mapper.lombok.mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.gblfy")
public class SpringbootMapperLombokMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMapperLombokMysqlApplication.class, args);
    }
}
