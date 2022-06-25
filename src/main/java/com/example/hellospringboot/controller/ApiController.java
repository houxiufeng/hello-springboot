package com.example.hellospringboot.controller;

import cn.hutool.core.date.DateUtil;
import com.example.hellospringboot.entity.Result;
import com.example.hellospringboot.entity.User;
import com.example.hellospringboot.service.TestService;
import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ApiController {

    private TestService testService;

    public ApiController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/hi")
    @Timed(value = "hello.api.stats", extraTags = {"uri", "/hi", "method", "GET"})
    public String sayHi() {
        String now = DateUtil.now();
        System.out.println("call sayHi at " + now);
        return String.format("hi, welcome to hello-springboot, now is %s", now);
    }

    @GetMapping("/user")
    @Timed(value = "hello.api.stats", extraTags = {"uri", "/user", "method", "GET"})
    public Result<User> user(Optional<Long> id) {
        Long aLong = id.orElse(null);
        User user = new User();
        user.setId(aLong);
        user.setName("fitz");
        user.setAge(20);
        System.out.println(String.format("call user id=%s at %s", id, DateUtil.now()));
        return Result.success(user);
    }

    @GetMapping("/hello-world")
    @Timed(value = "hello.api.stats", extraTags = {"uri", "/hello-world", "method", "GET"})
    public String helloWorld() {
        String now = DateUtil.now();
        System.out.println("call helloWorld at " + now);
        return testService.helloWorld();
    }

}
