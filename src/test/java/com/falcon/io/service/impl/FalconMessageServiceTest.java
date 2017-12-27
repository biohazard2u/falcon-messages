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

import com.falcon.io.dto.FalconMessageDTO;
import com.falcon.io.entity.FalconMessageEntity;
import com.falcon.io.repository.redis.FalconMessageRedisRepository;

@RunWith(MockitoJUnitRunner.class)
public class FalconMessageServiceTest {

	private static final int MESSAGE_ID = 1;
	private static final String OWNER = "Owner test";
	private static final String DESCRIPTION = "Description test";
	private static final Date DATE = new Date();

	@InjectMocks
	private FalconMessageService sut;

	@Mock
	private FalconMessageRedisRepository falconMessageRedisRepository;

	FalconMessageEntity falconMessageEntity;
	FalconMessageDTO falconMessageDto;

	@Before
	public void setUp() {
		sut = new FalconMessageService();

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

	@Ignore
	@Test
	public void findFalconMessageByOwner() {
		List<FalconMessageEntity> falconMessageEntities = new ArrayList<>();
		falconMessageEntities.add(falconMessageEntity);

		doReturn(falconMessageEntities).when(falconMessageRedisRepository).findByOwner(OWNER);

		List<FalconMessageEntity> actual = sut.findFalconMessageByOwner(OWNER);

		assertThat(actual, samePropertyValuesAs(falconMessageEntities));
	}

//	@Test
//	public void saveFalconMessage() {
//		sut.saveFalconMessage(falconMessageDto);
//		verify(falconMessageRedisRepository, times(1)).save(falconMessageEntity);
//	}
}
