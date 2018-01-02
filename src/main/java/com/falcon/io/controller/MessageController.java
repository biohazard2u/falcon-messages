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

import com.falcon.io.dto.ChatUserDTO;
import com.falcon.io.service.FalconChatUserServiceable;
import com.falcon.io.util.converter.ChatUserConverter;

@RestController
@RequestMapping("user")
public class MessageController {

	@Autowired
	FalconChatUserServiceable userService;

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ChatUserDTO> saveFalconChatUser(@RequestBody(required = false) ChatUserDTO user) {
		ChatUserDTO output = ChatUserConverter.falconChatUserEntiytTo2Dto(userService.saveFalconChatUser(user));
		return new ResponseEntity<>(output, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ChatUserDTO>> findFalconChatUsers() {
		List<ChatUserDTO> output = userService.findFalconChatUsers().stream()
                .map(ChatUserConverter::falconChatUserEntiytTo2Dto)
                .collect(Collectors.toList());
		return new ResponseEntity<>(output, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/userById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ChatUserDTO> findFalconChatUserById(@RequestParam(required = false) String id) {
		ChatUserDTO output = ChatUserConverter.falconChatUserEntiytTo2Dto(userService.findFalconChatUserById(id));
		return new ResponseEntity<>(output, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/userByEmail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ChatUserDTO> findFalconChatUserByEmail(@RequestParam(required = false) String email) {
		ChatUserDTO output = ChatUserConverter.falconChatUserEntiytTo2Dto(userService.findFalconChatUserByEmail(email));
		return new ResponseEntity<>(output, HttpStatus.OK);
	}
}
