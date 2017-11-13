package com.falcon.io.util.converter.redis;

import com.falcon.io.dto.FalconMessageDTO;
import com.falcon.io.entity.FalconMessageEntity;

public class RedisConverter {

	private RedisConverter() {
	}
	
	public static FalconMessageDTO falconMessageEntiytTo2Dto(FalconMessageEntity falconMessageEntity){
		if(falconMessageEntity == null)
			return null;
		FalconMessageDTO falconMessageDTO = new FalconMessageDTO();
		falconMessageDTO.setMessageId(falconMessageEntity.getMessageId());
		falconMessageDTO.setOwner(falconMessageEntity.getOwner());
		falconMessageDTO.setMessageDescription(falconMessageEntity.getMessageDescription());
		falconMessageDTO.setDate(falconMessageEntity.getDate());
		return falconMessageDTO;
	}
	
	public static FalconMessageEntity falconMessageDtoToEntity(FalconMessageDTO falconMessageDTO){
		if(falconMessageDTO == null)
			return null;
		FalconMessageEntity falconMessageEntity = new FalconMessageEntity();
		falconMessageEntity.setMessageId(falconMessageDTO.getMessageId());
		falconMessageEntity.setOwner(falconMessageDTO.getOwner());
		falconMessageEntity.setMessageDescription(falconMessageDTO.getMessageDescription());
		falconMessageEntity.setDate(falconMessageDTO.getDate());
		return falconMessageEntity;
	}
}