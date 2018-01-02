package com.falcon.io.repository.redis;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.falcon.io.entity.FalconChatUserEntity;

@Repository
public interface FalconChatUserRepository extends CrudRepository<FalconChatUserEntity, Integer> {

	void saveFalconChatUser(FalconChatUserEntity falconUser);
	
	List<FalconChatUserEntity> findAll();
	
	FalconChatUserEntity findByUserId(String userId);
	
	FalconChatUserEntity findByEmail(String email);
}