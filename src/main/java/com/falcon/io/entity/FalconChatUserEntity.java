package com.falcon.io.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RedisHash("user")
public class FalconChatUserEntity {

	@Id
	Integer userId;
	
	@Indexed
	String email;
	
	@Indexed
	String nickName;
	
	@Indexed
	String password;
	
	@Indexed
	Date date;
}