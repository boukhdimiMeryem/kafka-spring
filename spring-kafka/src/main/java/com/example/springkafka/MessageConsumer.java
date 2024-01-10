package com.example.springkafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @KafkaListener(topics = "mytopic", groupId = "groupe")
    public void consommerMessage(ConsumerRecord<String,String> cr){

        System.out.println("---------------");
        System.out.println(cr.key() + "=>"+ cr.value());
        System.out.println("---------------");

    }
}
