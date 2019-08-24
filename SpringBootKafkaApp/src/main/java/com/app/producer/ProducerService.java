package com.app.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

public class ProducerService {
	
	@Value("${my-topic-name}")
	private String topic;
	
	@Autowired
	private KafkaTemplate<String,String> kt;
	
	public void send(String message) {
		System.out.println("MESSAGE SENT FROM PRODUCER");
		kt.send(topic,message);
	}

}
