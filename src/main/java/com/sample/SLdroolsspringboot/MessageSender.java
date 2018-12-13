package com.sample.SLdroolsspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import util.OutputFormat;

//@Service
@Component
public class MessageSender {
	@Value("${spring.kafka.publish.topic}")
	private String publishTopic;
	
	@Autowired
	private KafkaTemplate<String, OutputFormat> kafkaTemplate;
	
	public void sendToKafka(OutputFormat outputEvent) {
		try {
			System.out.println("Sending message"+outputEvent.toString());
			kafkaTemplate.send(publishTopic, outputEvent);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	    
}
