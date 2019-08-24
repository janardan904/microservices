package com.app.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.app.persist.MessageStorage;

public class ConsumerService {
	@Autowired
	private MessageStorage ms;
	
	@KafkaListener(topics="${my-topic-name}",groupId="group-id")
	public void readMessage(String message) {
		System.out.println("CONSUMER IS EXECUTED");
		ms.save(message);
		
	}
	

}
