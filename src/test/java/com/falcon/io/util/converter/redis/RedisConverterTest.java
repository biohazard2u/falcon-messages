package com.falcon.io.util.converter.redis;

import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.falcon.io.dto.ChatUserDTO;
import com.falcon.io.entity.FalconChatUserEntity;

public class RedisConverterTest {

	private static final int USER_ID = 1;
	private static final String EMAIL = "Email test";
	private static final String PASSWORD = "Password test";
	private static final String NICKNAME = "Nickname test";
	private static final Date DATE = new Date();
	
	FalconChatUserEntity falconUserEntity;
	ChatUserDTO falconUserDto;
	
	@Before
	public void setUp(){
		falconUserEntity = new FalconChatUserEntity();
		falconUserEntity.setUserId(USER_ID);
		falconUserEntity.setEmail(EMAIL);
		falconUserEntity.setPassword(PASSWORD);
		falconUserEntity.setNickName(NICKNAME);
		falconUserEntity.setDate(DATE);
		
		falconUserDto = new ChatUserDTO();
		falconUserDto.setUserId(USER_ID);
		falconUserDto.setEmail(EMAIL);
		falconUserDto.setPassword(PASSWORD);
		falconUserDto.setNickName(NICKNAME);
		falconUserDto.setDate(DATE);
	}

	@Test
	public void falconChatUserEntiytTo2Dto_returnsRightObject() {
		ChatUserDTO actual = RedisConverter.falconChatUserEntiytTo2Dto(falconUserEntity);
		assertThat(actual, samePropertyValuesAs(falconUserDto));
	}

	@Test
	public void falconMessageDtoToEntity_returnsRightObject() {
		FalconChatUserEntity actual = RedisConverter.falconChatUserDtoToEntity(falconUserDto);
		assertThat(actual, samePropertyValuesAs(falconUserEntity));
	}
}