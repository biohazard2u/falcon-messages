package com.falcon.io.repository.postgre;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.falcon.io.entity.FalconMessageEntity;

public interface FalconMessagePostgreRepository extends CrudRepository<FalconMessageEntity, String> {
	
	List<FalconMessageEntity> findByOwner(String owner);
	
	void saveFalconMessage(FalconMessageEntity falconMessage);
}
