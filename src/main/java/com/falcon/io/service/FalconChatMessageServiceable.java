package com.falcon.io.service;

import java.util.List;

import com.falcon.io.dto.ChatMessageDTO;
import com.falcon.io.entity.FalconChatMessageEntity;

public interface FalconChatMessageServiceable {

	FalconChatMessageEntity saveFalconChatMessage(ChatMessageDTO falconChatMessage);

	List<FalconChatMessageEntity> findFalconChatMessagesByUserId(Integer id);
}