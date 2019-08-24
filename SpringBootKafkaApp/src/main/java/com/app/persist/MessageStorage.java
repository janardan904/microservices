package com.app.persist;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MessageStorage {
	
	private List<String> list=new ArrayList<>();
	public void save(String message) {
		list.add(message);
	}

	public String showAll() {
		return list.toString();
		
	}
}
