package com.example.springkafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class kafkaController {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    private String topic = "mytopic";

    @GetMapping("/publish/{message}")
    public String publishMessage(@PathVariable String message){
        kafkaTemplate.send(topic,message);
        return "message published";
    }

//    @GetMapping("/publish/{message}/{topic}")
//    public String publishMessage(@PathVariable String message,@PathVariable String topic){
//        kafkaTemplate.send(topic,message);
//        return "message published";
//    }

}
