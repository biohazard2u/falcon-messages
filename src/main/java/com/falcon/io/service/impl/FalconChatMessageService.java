package com.falcon.io.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.falcon.io.dto.ChatMessageDTO;
import com.falcon.io.entity.FalconChatMessageEntity;
import com.falcon.io.repository.postgre.FalconChatMessageRepository;
import com.falcon.io.service.FalconChatMessageServiceable;
import com.falcon.io.util.converter.ChatMessageConverter;

@Service
@Transactional
public class FalconChatMessageService implements FalconChatMessageServiceable {

	@Autowired
	FalconChatMessageRepository falconChatMessageRepository;
	
	@Override
	public FalconChatMessageEntity saveFalconChatMessage(ChatMessageDTO falconChatMessage) {
		FalconChatMessageEntity falconChatMessageEntity = ChatMessageConverter.falconChatMessageDtoToEntity(falconChatMessage);
		falconChatMessageRepository.save(falconChatMessageEntity);
		return falconChatMessageEntity;
	}

	@Override
	public List<FalconChatMessageEntity> findFalconChatMessagesByUserId(Integer id) {
		List<FalconChatMessageEntity> falconMessageEntities = new ArrayList<>();
		falconChatMessageRepository.findAll().forEach(falconMessageEntities::add);
        return falconMessageEntities;
	}
}