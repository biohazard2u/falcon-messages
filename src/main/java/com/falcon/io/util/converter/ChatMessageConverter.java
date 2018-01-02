package com.falcon.io.util.converter;

import com.falcon.io.dto.ChatMessageDTO;
import com.falcon.io.entity.FalconChatMessageEntity;

public class ChatMessageConverter {

	private ChatMessageConverter() {
	}
	
	public static ChatMessageDTO falconChatMessageEntiytTo2Dto(FalconChatMessageEntity falconChatMessageEntity){
		if(falconChatMessageEntity == null)
			return null;
		ChatMessageDTO falconChatMessageDTO = new ChatMessageDTO();
		falconChatMessageDTO.setMessageId(falconChatMessageEntity.getId());
		falconChatMessageDTO.setUserId(falconChatMessageEntity.getUserId());
		falconChatMessageDTO.setMessage(falconChatMessageEntity.getMessage());
		falconChatMessageDTO.setDate(falconChatMessageEntity.getDate());
		return falconChatMessageDTO;
	}
	
	public static FalconChatMessageEntity falconChatMessageDtoToEntity(ChatMessageDTO falconMessageDTO){
		if(falconMessageDTO == null)
			return null;
		FalconChatMessageEntity falconChatMessageEntity = new FalconChatMessageEntity();
		falconChatMessageEntity.setId(falconMessageDTO.getMessageId());
		falconChatMessageEntity.setUserId(falconMessageDTO.getUserId());
		falconChatMessageEntity.setMessage(falconMessageDTO.getMessage());
		falconChatMessageEntity.setDate(falconMessageDTO.getDate());
		return falconChatMessageEntity;
	}
}
