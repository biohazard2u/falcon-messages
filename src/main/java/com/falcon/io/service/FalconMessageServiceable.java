package com.falcon.io.service;

import java.util.List;

import com.falcon.io.dto.FalconMessageDTO;
import com.falcon.io.entity.FalconMessageEntity;

public interface FalconMessageServiceable {

	List<FalconMessageEntity> findFalconMessageByOwner(String owner);
	
	FalconMessageEntity saveFalconMessage(FalconMessageDTO falconMessage);	
}