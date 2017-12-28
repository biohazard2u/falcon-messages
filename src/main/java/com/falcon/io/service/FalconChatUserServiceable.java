package com.falcon.io.service;

import java.util.List;

import com.falcon.io.dto.ChatUserDTO;
import com.falcon.io.entity.FalconChatUserEntity;

public interface FalconChatUserServiceable {

	FalconChatUserEntity saveFalconChatUser(ChatUserDTO falconChatUser);

	List<FalconChatUserEntity> findFalconChatUsers();

	FalconChatUserEntity findFalconChatUserById(String id);

	FalconChatUserEntity findFalconChatUserByEmail(String email);
}