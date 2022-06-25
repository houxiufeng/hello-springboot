package com.example.hellospringboot.config;


import io.micrometer.core.aop.CountedAspect;
import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.Timer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

import javax.annotation.Nonnull;

@Configuration
public class MetricsConfiguration {

    @Bean
    public TimedAspect timedAspect(
            @Nonnull final MeterRegistry meterRegistry
    ) {
        System.out.println("----------------ffff------------------");
        return new TimedAspect(
                meterRegistry,
                proceedingJoinPoint -> Arrays.asList(Tag.of("myname","allen")),
                proceedingJoinPoint -> skipControllers(proceedingJoinPoint)
        );
    }

    @Bean("testTimer")
    public Timer statTimer(@Nonnull final MeterRegistry meterRegistry) {
        return Timer.builder("my.timer")
                .description("a description of what this timer does")
                .tags("region", "test", "author", "fitz")
                .register(meterRegistry);
    }

    @Bean("testxxxTimer")
    public Timer statxxxTimer(@Nonnull final MeterRegistry meterRegistry) {
        return Timer.builder("my.timerxxx")
//                .description("a description of what this timer does xxx")
//                .tags("region", "testxx", "author", "fitzxx")
                .register(meterRegistry);
    }

    private boolean skipControllers(ProceedingJoinPoint pjp) {
        Class<?> targetClass = pjp.getTarget().getClass();
        return targetClass.isAnnotationPresent(RestController.class) || targetClass.isAnnotationPresent(Controller.class);
    }

}
