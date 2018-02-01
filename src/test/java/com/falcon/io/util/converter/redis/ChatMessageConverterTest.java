package com.falcon.io.util.converter.redis;

import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.falcon.io.dto.ChatMessageDTO;
import com.falcon.io.entity.FalconChatMessageEntity;
import com.falcon.io.util.converter.ChatMessageConverter;

public class ChatMessageConverterTest {

	private static final int USER_ID = 1;
	private static final int MESSAGE_ID = 1;
	private static final String MESSAGE = "Message test";
	private static final Date DATE = new Date();
	
	FalconChatMessageEntity falconMessageEntity;
	ChatMessageDTO falconMessageDto;
	
	@Before
	public void setUp(){
		falconMessageEntity = new FalconChatMessageEntity();
		falconMessageEntity.setId(MESSAGE_ID);
		falconMessageEntity.setUserId(USER_ID);
		falconMessageEntity.setMessage(MESSAGE);
		falconMessageEntity.setDate(DATE);
		
		falconMessageDto = new ChatMessageDTO();
		falconMessageDto.setMessageId(MESSAGE_ID);
		falconMessageDto.setUserId(USER_ID);
		falconMessageDto.setMessage(MESSAGE);
		falconMessageDto.setDate(DATE);
	}

	@Test
	public void falconChatMessageEntiytTo2Dto_returnsRightObject() {
		ChatMessageDTO actual = ChatMessageConverter.falconChatMessageEntiytTo2Dto(falconMessageEntity);
		assertThat(actual, samePropertyValuesAs(falconMessageDto));
	}

	@Test
	public void falconChatMessageDtoToEntity_returnsRightObject() {
		FalconChatMessageEntity actual = ChatMessageConverter.falconChatMessageDtoToEntity(falconMessageDto);
		assertThat(actual, samePropertyValuesAs(falconMessageEntity));
	}
}
