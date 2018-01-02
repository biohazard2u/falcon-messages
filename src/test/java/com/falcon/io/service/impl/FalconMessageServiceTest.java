package com.falcon.io.service.impl;

import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.falcon.io.dto.ChatUserDTO;
import com.falcon.io.entity.FalconChatUserEntity;
import com.falcon.io.repository.redis.FalconChatUserRepository;

@RunWith(MockitoJUnitRunner.class)
public class FalconMessageServiceTest {

	private static final int MESSAGE_ID = 1;
	private static final String OWNER = "Owner test";
	private static final String DESCRIPTION = "Description test";
	private static final Date DATE = new Date();

	@InjectMocks
	private FalconChatUserService sut;

	@Mock
	private FalconChatUserRepository falconMessageRedisRepository;

	FalconChatUserEntity falconMessageEntity;
	ChatUserDTO falconMessageDto;

	@Before
	public void setUp() {
		sut = new FalconChatUserService();

		falconMessageEntity = new FalconChatUserEntity();
		falconMessageEntity.setUserId(MESSAGE_ID);
		falconMessageEntity.setEmail(DESCRIPTION);
		falconMessageEntity.setPassword(OWNER);
		falconMessageEntity.setNickName(DESCRIPTION);
		falconMessageEntity.setDate(DATE);

		falconMessageDto = new ChatUserDTO();
		falconMessageDto.setUserId(MESSAGE_ID);
		falconMessageDto.setEmail(OWNER);
		falconMessageDto.setPassword(DESCRIPTION);
		falconMessageDto.setNickName(DESCRIPTION);
		falconMessageDto.setDate(DATE);
	}

	@Ignore
	@Test
	public void findFalconMessageByOwner() {
		List<FalconChatUserEntity> falconMessageEntities = new ArrayList<>();
		falconMessageEntities.add(falconMessageEntity);

		//doReturn(falconMessageEntities).when(falconMessageRedisRepository).findByOwner(OWNER);

		//List<FalconChatUserEntity> actual = sut.findFalconChatUserById(OWNER);

		//assertThat(actual, samePropertyValuesAs(falconMessageEntities));
	}

//	@Test
//	public void saveFalconMessage() {
//		sut.saveFalconMessage(falconMessageDto);
//		verify(falconMessageRedisRepository, times(1)).save(falconMessageEntity);
//	}
}
