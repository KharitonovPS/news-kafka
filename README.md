## News Kafka Project
This project implements a simple Kafka setup for handling news messages in JSON format. It includes a Kafka cluster using Docker Compose, a Spring Kafka producer, a consumer, and relevant configurations.

## Docker Compose Configuration
The docker-compose.yaml file defines two services: Zookeeper and Kafka Broker, utilizing the Confluent Kafka images version 7.0.1. The Kafka broker depends on Zookeeper, and specific environment variables are set for each service.

### Kafka Topic Configuration
The KafkaTopicConfiguration class in the org.kharitonov.newskafka.config package sets up a Kafka topic named "news_json" using the TopicBuilder provided by Spring Kafka.

### Kafka Consumer
The JsonKafkaConsumer class in the org.kharitonov.newskafka.consumer package is a Kafka consumer that listens to the "news_json" topic and logs incoming JSON messages.

### Kafka Producer
The JsonKafkaProducer class in the org.kharitonov.newskafka.producer package is a Kafka producer that sends JSON messages to the "news_json" topic.

### Kafka Controller
The JsonNewsController class in the org.kharitonov.newskafka.controller package provides a REST endpoint /api/v2/kafka/publish for publishing JSON news messages. It uses the JsonKafkaProducer to send messages to the Kafka topic.

### Spring Boot Configuration
The application.yaml file configures the Spring Kafka properties for both the producer and the consumer. The consumer is set to auto-reset to the earliest offset, and the producer uses JSON serialization.

### How to Run
1) Clone the repository.

2) Navigate to the project directory.

3) Run the following command to start the Docker containers:

docker-compose up -d
Run the Spring Boot application.

Now, the Kafka setup is ready, and you can use the /api/v2/kafka/publish endpoint to send JSON news messages to the Kafka topic.

Feel free to customize the configurations and classes according to your requirements.





