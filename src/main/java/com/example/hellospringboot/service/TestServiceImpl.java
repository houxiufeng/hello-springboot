package com.example.hellospringboot.service;

import com.example.hellospringboot.common.SpringContextUti;
import com.example.hellospringboot.common.SpringContextUtil2;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.Timer.Sample;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.TimeZone;

@Service
public class TestServiceImpl implements TestService{


    private Timer testTimer;
    @Autowired
    private MeterRegistry meterRegistry;
//
//    @Autowired
//    private Timer testxxxTimer;
//
//    @Autowired
//    public TestServiceImpl(Timer testTimer) {
//        this.testTimer = testTimer;
//    }

    @Override
    @Timed("hello.service.stats")
    public String helloWorld() {

//        timer.record(() -> {
//            try {
//                Thread.sleep(5000L);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });

//        Timer.Sample sample = Timer.start();
//        try {
//            Thread.sleep(3000L);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        Timer testTimer = SpringContextUtil2.getBean("testxxxTimer");
//        sample.stop(testTimer);

//        OffsetDateTime offsetDateTime = OffsetDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), TimeZone.getDefault().toZoneId());

//        OffsetDateTime t1 = Instant.ofEpochSecond(System.currentTimeMillis()).atOffset(atOffset);

//        OffsetDateTime offsetDateTime = OffsetDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), TimeZone.getDefault().toZoneId());
//        System.out.println(offsetDateTime);
////
//        OffsetDateTime offsetDateTime1 = offsetDateTime.minusSeconds(1);
//        System.out.println(offsetDateTime1);
//
//        Duration between = Duration.between(offsetDateTime1, offsetDateTime);
//        System.out.println(between.toMillis());
//
//        testTimer.record(between);

//        Timer testxxxTimer = SpringContextUti.getBean("testxxxTimer");
//        Timer.Sample sample2 = Timer.start();
//        try {
//            Thread.sleep(1000L);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        sample2.stop(testxxxTimer);

//        new TestManager().sayHey();

        record();


        return "hello world";
    }

    private void record() {
        if (this.testTimer == null) {
            this.testTimer = Timer.builder("search.engine.ingestor.received").tag("a","aa").register(meterRegistry);
        }

        testTimer.record(Duration.of(1, ChronoUnit.SECONDS));
    }
}
