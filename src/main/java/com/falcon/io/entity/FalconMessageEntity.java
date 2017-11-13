package com.falcon.io.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RedisHash("message")
public class FalconMessageEntity {

	@Id
	Integer messageId;
	
	@Indexed
	String owner;
	
	@Indexed
	String messageDescription;
	
	@Indexed
	Date date;
}