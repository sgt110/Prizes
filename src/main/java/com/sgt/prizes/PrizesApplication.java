package com.sgt.prizes;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author sungt
 */
@SpringBootApplication
@MapperScan(basePackages = "com.sgt.prizes.dal")
public class PrizesApplication {

    public static void main(String[] args) {
        SpringApplication.run(PrizesApplication.class, args);
    }

}
