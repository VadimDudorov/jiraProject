package ru.jiraproject.jira.configuration;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@EnableKafka
@Configuration
@RequiredArgsConstructor
public class KafkaConfig {

    private final KafkaProperties kafkaProperties;

    /**
     * Конфигурация получателя сообщений из Kafka.
     *
     * @return consumer.
     */
    @Bean
    public DefaultKafkaConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(
                kafkaProperties.buildConsumerProperties(),
                new StringDeserializer(),
                new StringDeserializer()
        );
    }

    /**
     * Конфигурация основного KafkaTemplate.
     *
     * @return kafkaTemplate.
     */
    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {

        ProducerFactory<String, String> factory = new DefaultKafkaProducerFactory<>(
                kafkaProperties.buildProducerProperties(),
                new StringSerializer(),
                new StringSerializer()
        );

        return new KafkaTemplate<>(factory);
    }
}