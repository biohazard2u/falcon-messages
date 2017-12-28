package com.falcon.io.repository.postgre;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.falcon.io.entity.FalconChatUserEntity;

public interface FalconMessagePostgreRepository extends CrudRepository<FalconChatUserEntity, String> {
	
	List<FalconChatUserEntity> findByOwner(String owner);
	
	void saveFalconMessage(FalconChatUserEntity falconMessage);
}
