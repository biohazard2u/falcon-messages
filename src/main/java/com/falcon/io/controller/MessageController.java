package com.falcon.io.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.falcon.io.dto.ChatMessageDTO;
import com.falcon.io.service.FalconChatMessageServiceable;
import com.falcon.io.util.converter.ChatMessageConverter;

@RestController
@RequestMapping("message")
public class MessageController {

	@Autowired
	FalconChatMessageServiceable messageService;

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ChatMessageDTO> saveFalconChatMessage(@RequestBody(required = false) ChatMessageDTO message) {
		ChatMessageDTO output = ChatMessageConverter.falconChatMessageEntiytTo2Dto(messageService.saveFalconChatMessage(message));
		return new ResponseEntity<>(output, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/MessageUserId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ChatMessageDTO>> findFalconChatMessagesByUserId(@RequestParam Integer id) {
		List<ChatMessageDTO> output = messageService.findFalconChatMessagesByUserId(id).stream()
                .map(ChatMessageConverter::falconChatMessageEntiytTo2Dto)
                .collect(Collectors.toList());
		return new ResponseEntity<>(output, HttpStatus.OK);
	}
}
