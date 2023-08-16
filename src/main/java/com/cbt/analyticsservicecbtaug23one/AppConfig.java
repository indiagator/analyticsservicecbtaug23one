package com.cbt.analyticsservicecbtaug23one;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig
{
    @Bean
    public Counter analyticsDataCounter(MeterRegistry registry)
    {
        return Counter.builder("analytics_data_counter_messages").register(registry);
    }

    @Bean
    public Counter offerCounter(MeterRegistry registry)
    {
        return Counter.builder("offer_counter_count").register(registry);
    }

}
