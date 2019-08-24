package com.app.router;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;
@Component
public class MyRouter extends RouteBuilder {

	public void configure() throws Exception {
		from ("file://H:/sourceFiles").process(new Processor() {

			
			public void process(Exchange ex) throws Exception {
				
				//read input message
				Message m1=ex.getIn();
				
				//Read body as String 
				String data=m1.getBody(String.class);
				//modify data
				data="HELLO:"+data;
				//get output message object
				Message m2=ex.getOut();
				//set data to out message 
				m2.setBody(data);
			
			}
		
	})
	.to("file://H:/destiFiles?fileName=Myoutput.txt");

	
}

}