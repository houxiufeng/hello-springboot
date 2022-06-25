package com.example.hellospringboot;

import com.example.hellospringboot.common.SpringContextUti;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class HelloSpringbootApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext app = SpringApplication.run(HelloSpringbootApplication.class, args);
        SpringContextUti.setApplicationContext(app);
    }

}
