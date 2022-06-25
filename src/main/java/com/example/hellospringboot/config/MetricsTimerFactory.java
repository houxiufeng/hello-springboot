package com.example.hellospringboot.config;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class MetricsTimerFactory {
//    @Autowired
    private MeterRegistry meterRegistry;

    public Timer timer1;
}
