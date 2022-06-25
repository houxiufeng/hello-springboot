package com.example.hellospringboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.TimeZone;

@SpringBootTest
class HelloSpringbootApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test1() {
        long l = System.currentTimeMillis();
        System.out.println(l);
        OffsetDateTime offsetDateTime = OffsetDateTime.ofInstant(Instant.ofEpochMilli(l), TimeZone.getDefault().toZoneId());
        System.out.println(offsetDateTime);
        System.out.println(OffsetDateTime.now());
        System.out.println(offsetDateTime.toInstant().toEpochMilli());

//        OffsetDateTime offsetDateTime1 = offsetDateTime.minusHours(1);
//        System.out.println(offsetDateTime1);
//
//        Duration between = Duration.between(offsetDateTime1, offsetDateTime);
//        System.out.println(between.toMillis());

    }

}
