package org.kharitonov.newskafka.controller;

import org.kharitonov.newskafka.dto.News;
import org.kharitonov.newskafka.producer.JsonKafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/kafka")
public class JsonNewsController {

    private final JsonKafkaProducer jsonKafkaProducer;

    public JsonNewsController(JsonKafkaProducer jsonKafkaProducer) {
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody News news) {
        jsonKafkaProducer.sendMessage(news);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }
}



