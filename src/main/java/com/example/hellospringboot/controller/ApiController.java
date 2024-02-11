package com.example.hellospringboot.controller;

import cn.hutool.core.date.DateUtil;
import com.example.hellospringboot.entity.Result;
import com.example.hellospringboot.entity.ResultStatus;
import com.example.hellospringboot.entity.User;
import com.example.hellospringboot.service.TestService;
import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
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
    public Result<User> user(@RequestHeader Map<String, String> headers,Optional<Long> id) {
        Long aLong = id.orElse(null);
        User user = new User();
        user.setId(aLong);
        user.setName("fitz");
        user.setAge(20);
        System.out.println("headers---->" + headers);
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

    @PostMapping("/form-test")
    public Result<String> formTest(@RequestHeader Map<String, String> headers, @RequestParam String name, Integer age) {
        String now = DateUtil.now();
        System.out.println("call formTest at " + now);
        return new Result(ResultStatus.SUCCESS.getCode(), "name: " + name + ", age: " + age + ", now is " + now, "headers:" + headers);
    }

    @PostMapping("/user")
    public Result<User> saveUser(@RequestHeader Map<String, String> headers, @RequestBody User user) {
        String now = DateUtil.now();
        System.out.println("call saveUser at " + now + ", headers: " + headers);
        return new Result(ResultStatus.SUCCESS.getCode(), user, "headers:" + headers);
    }

    @PutMapping("/user")
    public Result<User> updateUser(@RequestHeader Map<String, String> headers, @RequestBody User user) {
        String now = DateUtil.now();
        System.out.println("call updateUser at " + now + ", headers: " + headers);
        return new Result(ResultStatus.SUCCESS.getCode(), user, "headers:" + headers);
    }

    @DeleteMapping("/user")
    public Result<User> deleteUser(@RequestHeader Map<String, String> headers, @RequestParam Long id) {
        String now = DateUtil.now();
        System.out.println("call deleteUser at " + now + ", headers: " + headers);
        return new Result(ResultStatus.SUCCESS.getCode(), "delete user:" + id, "headers:" + headers);
    }

}
