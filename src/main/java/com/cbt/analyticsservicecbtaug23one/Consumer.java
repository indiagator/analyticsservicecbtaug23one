package com.cbt.analyticsservicecbtaug23one;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.core.instrument.Counter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer
{
    private final Logger logger = LoggerFactory.getLogger(Consumer.class);

    @Qualifier("analyticsDataCounter")
    @Autowired
    Counter analytics_counter;

    @Qualifier("offerCounter")
    @Autowired
    Counter offer_counter;
    @KafkaListener(topics = "analytics", groupId = "group_id")
    public void consume(String message) throws IOException
    {

        analytics_counter.increment();

        ObjectMapper mapper  = new ObjectMapper();

         AnalyticsDatum datum =  mapper.readValue(message,AnalyticsDatum.class);

         switch (datum.getType())
         {
             case "CREDENTIAL"   : logger.info(String.format("#### -> Consumed message -> %s", datum.getMessage()));break;
             case "USERDETAIL"   : logger.info( datum.getMessage()+" ---> "+mapper.readValue(datum.getPayload(), Userdetail.class));break;
             case "PRODUCTOFFER" : logger.
                     info(datum.getMessage()+" ---> "+mapper.readValue(datum.getPayload(), Productoffer.class));offer_counter.increment();break;
             default: logger.info(message);
         }
    }
}

