package com.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.persist.MessageStorage;
import com.app.producer.ProducerService;

@RestController
@RequestMapping("/kafka")
public class KafkaRestController {
	@Autowired
	private ProducerService producer;
	@Autowired
	private MessageStorage ms;
	
	@GetMapping("/send")
	public String sendMessage(
			@RequestParam String message) {
		producer.send(message);
		return "SENT MSG is=>"+message;
	}
	
	@GetMapping("/all")
	public String getMessagesFromConsumer() {
		return "From Consumer =>"+ms.showAll();
	}
	
}


