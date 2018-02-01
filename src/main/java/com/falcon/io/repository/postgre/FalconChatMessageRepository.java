package com.falcon.io.repository.postgre;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.falcon.io.entity.FalconChatMessageEntity;

@Repository
public interface FalconChatMessageRepository extends CrudRepository<FalconChatMessageEntity, Integer> {

	List<FalconChatMessageEntity> findByUserId(Integer userId);
}