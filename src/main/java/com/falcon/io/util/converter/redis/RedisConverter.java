package com.falcon.io.util.converter.redis;

import com.falcon.io.dto.ChatUserDTO;
import com.falcon.io.entity.FalconChatUserEntity;

public class RedisConverter {

	private RedisConverter() {
	}
	
	public static ChatUserDTO falconChatUserEntiytTo2Dto(FalconChatUserEntity falconChatUserEntity){
		if(falconChatUserEntity == null)
			return null;
		ChatUserDTO falconChatUserDTO = new ChatUserDTO();
		falconChatUserDTO.setUserId(falconChatUserEntity.getUserId());
		falconChatUserDTO.setEmail(falconChatUserEntity.getEmail());
		falconChatUserDTO.setNickName(falconChatUserEntity.getNickName());
		falconChatUserDTO.setPassword(falconChatUserEntity.getPassword());
		falconChatUserDTO.setDate(falconChatUserEntity.getDate());
		return falconChatUserDTO;
	}
	
	public static FalconChatUserEntity falconChatUserDtoToEntity(ChatUserDTO falconUserDTO){
		if(falconUserDTO == null)
			return null;
		FalconChatUserEntity falconChatUserEntity = new FalconChatUserEntity();
		falconChatUserEntity.setUserId(falconUserDTO.getUserId());
		falconChatUserEntity.setEmail(falconUserDTO.getEmail());
		falconChatUserEntity.setNickName(falconUserDTO.getNickName());
		falconChatUserEntity.setPassword(falconUserDTO.getPassword());
		falconChatUserEntity.setDate(falconUserDTO.getDate());
		return falconChatUserEntity;
	}
}