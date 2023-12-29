package org.kharitonov.newskafka.consumer;

import lombok.extern.slf4j.Slf4j;
import org.kharitonov.newskafka.dto.News;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JsonKafkaConsumer {

    @KafkaListener(topics = "news_json", groupId = "group-1")
    public void consume(News news) {
        log.info("Json message was received -> {}", news.toString());
    }

}
