package se.marcuskarlberg.items.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.Map;

@Configuration
public class KafkaConfig {

    private final String itemsReservedEventTopic;

    public KafkaConfig(@Value("${items.reserved.events.topic.name}") String itemsReservedEventTopic) {
        this.itemsReservedEventTopic = itemsReservedEventTopic;
    }

    //TODO: add config

    @Bean
    public NewTopic itemsReservedEventTopic() {
        return TopicBuilder.name(itemsReservedEventTopic)
                .partitions(3)
                .replicas(1)
                .configs(Map.of("min.insync.replicas", "1"))
                .build();
    }
}
