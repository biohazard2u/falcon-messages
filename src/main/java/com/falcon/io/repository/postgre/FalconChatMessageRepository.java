package com.falcon.io.repository.postgre;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.falcon.io.entity.FalconChatMessageEntity;

public interface FalconChatMessageRepository extends CrudRepository<FalconChatMessageEntity, Integer> {

	List<FalconChatMessageEntity> findByUserId(Integer userId);
}