package com.falcon.io.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.falcon.io.dto.FalconMessageDTO;

@Controller
public class MessageWebSocketController {

	@MessageMapping("/chat")
	@SendTo("/topic/messages")
	public FalconMessageDTO greeting(FalconMessageDTO message) throws Exception {
		Thread.sleep(1000); // simulated delay
		FalconMessageDTO falconMessageDTO = new FalconMessageDTO();
		falconMessageDTO.setOwner("Erika");
		return falconMessageDTO;
	}
	// http://localhost:8081/spring-mvc-java/resources/chat.html
	// http://localhost:8081/falcon-message-service/spring-mvc-java/resources/chat.html
	
	//http://localhost:8081/falcon-message-service/hello/chat.html
}
