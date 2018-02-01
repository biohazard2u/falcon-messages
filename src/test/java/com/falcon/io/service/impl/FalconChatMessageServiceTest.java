package com.falcon.io.service.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.falcon.io.dto.ChatMessageDTO;
import com.falcon.io.entity.FalconChatMessageEntity;
import com.falcon.io.repository.postgre.FalconChatMessageRepository;

@RunWith(SpringRunner.class)
public class FalconChatMessageServiceTest {

	private static final Integer USER1_ID = 1;
	private static final int MESSAGE_ID1 = 1;
	private static final int MESSAGE_ID2 = 2;
	private static final String MESSAGE1 = "Message test";
	private static final String MESSAGE2 = "Message test2";
	private static final Date DATE = new Date();
	
	@TestConfiguration
	static class FalconChatMessageServiceTestContextConfiguration {
		
		@Bean
		public FalconChatMessageService falconChatMessageService(){
			return new FalconChatMessageService();
		}
	}
	
	@Autowired
	private FalconChatMessageService falconChatMessageService;
	
	@MockBean
	private FalconChatMessageRepository falconChatMessageRepository;
	
	FalconChatMessageEntity falconChatMessageEntity1;
	FalconChatMessageEntity falconChatMessageEntity2;
	
	@Before
	public void setUp(){
		falconChatMessageEntity1 = new FalconChatMessageEntity();
		falconChatMessageEntity1.setId(MESSAGE_ID1);
		falconChatMessageEntity1.setUserId(USER1_ID);
		falconChatMessageEntity1.setMessage(MESSAGE1);
		falconChatMessageEntity1.setDate(DATE);
		falconChatMessageEntity2 = new FalconChatMessageEntity();
		falconChatMessageEntity2.setId(MESSAGE_ID2);
		falconChatMessageEntity2.setUserId(USER1_ID);
		falconChatMessageEntity2.setMessage(MESSAGE2);
		falconChatMessageEntity2.setDate(DATE);
	}
	
	@Test
	public void findFalconChatMessagesByUserId_returnsAllMessagesByUserId() {
		List<FalconChatMessageEntity> expected = new ArrayList<>();
		
		expected.add(falconChatMessageEntity1);
		expected.add(falconChatMessageEntity2);
		
		Mockito.when(falconChatMessageRepository.findByUserId(USER1_ID)).thenReturn(expected);
		
		List<FalconChatMessageEntity> actualList = falconChatMessageService.findFalconChatMessagesByUserId(USER1_ID);
		assertThat(actualList, is(expected));
	}

	@Test
	public void saveFalconChatMessage_collectsDTO_andReturnsSavedEntity(){
		ChatMessageDTO falconChatMessageDTO = new ChatMessageDTO();
		falconChatMessageDTO.setMessageId(MESSAGE_ID1);
		falconChatMessageDTO.setUserId(USER1_ID);
		falconChatMessageDTO.setMessage(MESSAGE1);
		falconChatMessageDTO.setDate(DATE);

		Mockito.when(falconChatMessageRepository.save(falconChatMessageEntity1)).thenReturn(falconChatMessageEntity1);
		
		FalconChatMessageEntity actual = falconChatMessageService.saveFalconChatMessage(falconChatMessageDTO);
		
		assertEquals(falconChatMessageEntity1.getId(), actual.getId());
		assertEquals(falconChatMessageEntity1.getUserId(), actual.getUserId());
		assertEquals(falconChatMessageEntity1.getMessage(), actual.getMessage());
		assertEquals(falconChatMessageEntity1.getDate(), actual.getDate());
	}
}