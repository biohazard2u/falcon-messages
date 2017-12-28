package com.falcon.io.dto;

import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description = "A single user on the Falcon.io application/chat")
public class ChatUserDTO extends ResourceSupport {

	@ApiModelProperty(value = "USER ID")
	@JsonProperty("userId")
	Integer userId;

	@ApiModelProperty(value = "USER'S EMAIL")
	@JsonProperty("email")
	String email;

	@ApiModelProperty(value = "USER'S NICKNAME")
	@JsonProperty("usersNickname")
	String nickName;

	@ApiModelProperty(value = "PASSWORD")
	@JsonProperty("password")
	String password;
	
	@ApiModelProperty(value = "USER'S REGISTRY'S DATE")
	@JsonProperty("date")
	Date date;
}
