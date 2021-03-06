package com.sample.SLdroolsspringboot;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

//@EnableKafka
@Configuration
public class SenderConfig {
	
	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServers;
	
	@Bean
	  public ProducerFactory<String, SLJournalEntry> producerFactory() {
	    return new DefaultKafkaProducerFactory<>(
	    		producerConfigs(),
	    		new StringSerializer(),
	    		new JsonSerializer<>());
	  }
	
	@Bean
	  public Map<String, Object> producerConfigs() {
	    Map<String, Object> props = new HashMap<>();
	    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
	    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
	    /*props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "util.OutputFormatSerializer");*/
	    props.put(ProducerConfig.ACKS_CONFIG, "all");
	    return props;
	  }
	
	@Bean
	  public KafkaTemplate<String, SLJournalEntry> kafkaTemplate() {
	    return new KafkaTemplate<>(producerFactory());
	  }
}
