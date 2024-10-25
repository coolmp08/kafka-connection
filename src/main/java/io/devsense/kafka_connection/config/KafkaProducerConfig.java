package io.devsense.kafka_connection.config;

import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

import static io.devsense.kafka_connection.config.ProducerConfig.*;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public ProducerFactory<String, String> producerFactory(){
        Map<String, Object> configProperties = new HashMap<>();
        configProperties.put(BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        configProperties.put(KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProperties.put(VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        return new DefaultKafkaProducerFactory<>(configProperties);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }
}
