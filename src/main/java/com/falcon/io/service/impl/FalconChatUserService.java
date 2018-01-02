package com.falcon.io.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.falcon.io.dto.ChatUserDTO;
import com.falcon.io.entity.FalconChatUserEntity;
import com.falcon.io.repository.redis.FalconChatUserRepository;
import com.falcon.io.service.FalconChatUserServiceable;
import com.falcon.io.util.converter.ChatUserConverter;

@Service
@Transactional
public class FalconChatUserService implements FalconChatUserServiceable {

	@Autowired
	FalconChatUserRepository falconMessageRedisRepository;
	
	@Override
	public FalconChatUserEntity saveFalconChatUser(ChatUserDTO falconMessageDto) {
		FalconChatUserEntity falconMessageEntity = ChatUserConverter.falconChatUserDtoToEntity(falconMessageDto);
		falconMessageRedisRepository.save(falconMessageEntity);
		return falconMessageEntity;
	}
	
	@Override
	public List<FalconChatUserEntity> findFalconChatUsers() {
		List<FalconChatUserEntity> falconMessageEntities = new ArrayList<>();
		falconMessageRedisRepository.findAll().forEach(falconMessageEntities::add);
        return falconMessageEntities;
	}

	@Override
	public FalconChatUserEntity findFalconChatUserById(String id) {
        return falconMessageRedisRepository.findByUserId(id);
	}

	@Override
	public FalconChatUserEntity findFalconChatUserByEmail(String email) {
		return falconMessageRedisRepository.findByEmail(email);
	}
}