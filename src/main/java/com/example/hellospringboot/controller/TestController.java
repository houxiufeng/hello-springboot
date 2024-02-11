package com.example.hellospringboot.controller;

import com.example.hellospringboot.service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TestController {
    /**
     * 按照官方文档的说法, 如果一个bean有一个构造器，就可以省略@Autowired
     * If a bean has one constructor, you can omit the @Autowired
     */
    private TestService testService;

    @RequestMapping("hi")
    public String testHi() {
        String s = testService.helloWorld();
        return "hi man! " + s;
    }
}
