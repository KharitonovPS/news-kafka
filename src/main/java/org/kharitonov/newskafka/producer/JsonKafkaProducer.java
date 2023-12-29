package org.kharitonov.newskafka.producer;

import lombok.extern.slf4j.Slf4j;
import org.kharitonov.newskafka.dto.News;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JsonKafkaProducer {

    private final KafkaTemplate<String, News> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, News> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(News data) {
        log.info("Message sent ->" + data.toString());
        Message<News> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "news_json")
                .build();
        kafkaTemplate.send(message);
    }
}
