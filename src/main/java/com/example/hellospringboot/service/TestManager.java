package com.example.hellospringboot.service;

import com.example.hellospringboot.common.SpringContextUtil3;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class TestManager {

    private MeterRegistry meterRegistry;

    public void sayHey() {
        meterRegistry = SpringContextUtil3.getBean("simpleMeterRegistry");
        Timer register = Timer.builder("search.test")
                .tags("aa", "axxxxxx", "bb", "bxxxxxxx")
                .register(meterRegistry);
        register.record(Duration.of(60L, ChronoUnit.SECONDS));

        System.out.println("hey, guys");
    }
}
