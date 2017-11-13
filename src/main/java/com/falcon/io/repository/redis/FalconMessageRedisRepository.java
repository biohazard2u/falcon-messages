package com.falcon.io.repository.redis;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.falcon.io.entity.FalconMessageEntity;

@Repository
public interface FalconMessageRedisRepository extends CrudRepository<FalconMessageEntity, Integer> {

	List<FalconMessageEntity> findByOwner(String owner);
	
	void saveFalconMessage(FalconMessageEntity falconMessage);
}