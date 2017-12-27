package com.falcon.io.repository.postgre;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.falcon.io.entity.FalconMessageEntity;

public interface FalconMessagePostgreRepository extends CrudRepository<FalconMessageEntity, String> {
	
			//extends ReactiveCrudRepository<FalconMessageEntity, String> {
//	Mono<FalconMessageEntity> findByMessageId(Integer messageId);
//	Flux<FalconMessageEntity> findByOwner(final String lastname);
	
	List<FalconMessageEntity> findByOwner(String owner);
	
	void saveFalconMessage(FalconMessageEntity falconMessage);
}
