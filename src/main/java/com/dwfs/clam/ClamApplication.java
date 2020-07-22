package com.dwfs.clam;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication()
@PropertySource(value = "classpath:appli.properties")
@MapperScan("com.dwfs.clam.dao")
public class ClamApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClamApplication.class, args);
    }

}
