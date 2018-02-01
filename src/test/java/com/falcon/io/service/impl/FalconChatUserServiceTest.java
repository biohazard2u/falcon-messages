package com.falcon.io.service.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.beans.SamePropertyValuesAs.samePropertyValuesAs;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.falcon.io.dto.ChatUserDTO;
import com.falcon.io.entity.FalconChatUserEntity;
import com.falcon.io.repository.redis.FalconChatUserRepository;

@RunWith(MockitoJUnitRunner.class)
public class FalconChatUserServiceTest {
	
	private static final String USER1_ID = "1";
	private static final String EMAIL1 = "test1@email";
	private static final String NICKNAME1 = "nicknameTest1";
	private static final Date DATE = new Date();
	
	@InjectMocks
	private FalconChatUserService sut;
	
	@Mock
	private FalconChatUserRepository falconChatUserRepository;

	FalconChatUserEntity falconChatUserEntity; 
	
	@Before
	public void setUp() {
		falconChatUserEntity = new FalconChatUserEntity();
		falconChatUserEntity.setUserId(Integer.valueOf(USER1_ID));
		falconChatUserEntity.setEmail(EMAIL1);
		falconChatUserEntity.setNickName(NICKNAME1);
		falconChatUserEntity.setDate(DATE);
	}

	@Test
	public void saveFalconChatUser_forGivenDTO_StoresAndReturnsEntity(){
		ChatUserDTO falconMessageDto = new ChatUserDTO();
		falconMessageDto.setUserId(Integer.valueOf(USER1_ID));
		falconMessageDto.setEmail(EMAIL1);
		falconMessageDto.setNickName(NICKNAME1);
		falconMessageDto.setDate(DATE);
		
		doReturn(falconChatUserEntity).when(falconChatUserRepository).save(falconChatUserEntity);
		
		FalconChatUserEntity actual = sut.saveFalconChatUser(falconMessageDto);
		
		assertThat(actual, samePropertyValuesAs(falconChatUserEntity));
	}
	
	@Test
	public void findFalconChatUsers_findsAllUsers(){
		List<FalconChatUserEntity> expected = new ArrayList<>();
		expected.add(falconChatUserEntity);
		
		doReturn(expected).when(falconChatUserRepository).findAll();
		
		List<FalconChatUserEntity>  actual = sut.findFalconChatUsers();
		
		assertThat(actual, is(expected));
	}
	
	@Test
	public void findFalconChatUserById_findsUserWithThatId(){		
		doReturn(falconChatUserEntity).when(falconChatUserRepository).findByUserId(USER1_ID);

		FalconChatUserEntity actual = sut.findFalconChatUserById(USER1_ID);

		assertThat(actual, samePropertyValuesAs(falconChatUserEntity));
		
	}
	
	@Test
	public void findFalconChatUserByEmail_findsUserWithThatEmail() {		
		doReturn(falconChatUserEntity).when(falconChatUserRepository).findByEmail(EMAIL1);

		FalconChatUserEntity actual = sut.findFalconChatUserByEmail(EMAIL1);

		assertThat(actual, samePropertyValuesAs(falconChatUserEntity));
	}
}
