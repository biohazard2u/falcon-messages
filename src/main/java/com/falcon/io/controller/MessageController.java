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

import com.falcon.io.dto.FalconMessageDTO;
import com.falcon.io.service.FalconMessageServiceable;
import com.falcon.io.util.converter.redis.RedisConverter;

@RestController
@RequestMapping("message")
public class MessageController {

	@Autowired
	FalconMessageServiceable falconMessageService;
	
	@RequestMapping(value = "/messagesByOwner", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FalconMessageDTO>> findFalconMessageByOwner(@RequestParam(required = false) String owner) {
		List<FalconMessageDTO> output = falconMessageService.findFalconMessageByOwner(owner).stream()
                .map(RedisConverter::falconMessageEntiytTo2Dto)
                .collect(Collectors.toList());
		return new ResponseEntity<>(output, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FalconMessageDTO> saveFalconMessage(@RequestBody FalconMessageDTO message) {
		FalconMessageDTO output = RedisConverter.falconMessageEntiytTo2Dto(falconMessageService.saveFalconMessage(message));
		return new ResponseEntity<>(output, HttpStatus.OK);
	}
}
