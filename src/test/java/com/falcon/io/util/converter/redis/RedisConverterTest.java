package com.falcon.io.util.converter.redis;

import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.falcon.io.dto.FalconMessageDTO;
import com.falcon.io.entity.FalconMessageEntity;

public class RedisConverterTest {

	private static final int MESSAGE_ID = 1;
	private static final String OWNER = "Owner test";
	private static final String DESCRIPTION = "Description test";
	private static final Date DATE = new Date();
	
	FalconMessageEntity falconMessageEntity;
	FalconMessageDTO falconMessageDto;
	
	@Before
	public void setUp(){
		falconMessageEntity = new FalconMessageEntity();
		falconMessageEntity.setMessageId(MESSAGE_ID);
		falconMessageEntity.setOwner(OWNER);
		falconMessageEntity.setMessageDescription(DESCRIPTION);
		falconMessageEntity.setDate(DATE);
		
		falconMessageDto = new FalconMessageDTO();
		falconMessageDto.setMessageId(MESSAGE_ID);
		falconMessageDto.setOwner(OWNER);
		falconMessageDto.setMessageDescription(DESCRIPTION);
		falconMessageDto.setDate(DATE);
	}

	@Test
	public void falconMessageEntiytTo2Dto_returnsRightObject() {
		FalconMessageDTO actual = RedisConverter.falconMessageEntiytTo2Dto(falconMessageEntity);
		assertThat(actual, samePropertyValuesAs(falconMessageDto));
	}

	@Test
	public void falconMessageDtoToEntity_returnsRightObject() {
		FalconMessageEntity actual = RedisConverter.falconMessageDtoToEntity(falconMessageDto);
		assertThat(actual, samePropertyValuesAs(falconMessageEntity));
	}
}