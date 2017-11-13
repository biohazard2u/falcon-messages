package com.falcon.io.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.falcon.io.dto.FalconMessageDTO;
import com.falcon.io.entity.FalconMessageEntity;
import com.falcon.io.repository.redis.FalconMessageRedisRepository;
import com.falcon.io.service.FalconMessageServiceable;
import com.falcon.io.util.converter.redis.RedisConverter;

@Service
@Transactional
public class FalconMessageService implements FalconMessageServiceable {

	@Autowired
	FalconMessageRedisRepository falconMessageRedisRepository;
	
	@Override
	public List<FalconMessageEntity> findFalconMessageByOwner(String owner) {
		List<FalconMessageEntity> falconMessageEntities = new ArrayList<>();
		falconMessageRedisRepository.findByOwner(owner).forEach(falconMessageEntities::add);
        return falconMessageEntities;
	}
	
	@Override
	public FalconMessageEntity saveFalconMessage(FalconMessageDTO falconMessageDto) {
		FalconMessageEntity falconMessageEntity = RedisConverter.falconMessageDtoToEntity(falconMessageDto);
		falconMessageRedisRepository.save(falconMessageEntity);
		return falconMessageEntity;
	}
}