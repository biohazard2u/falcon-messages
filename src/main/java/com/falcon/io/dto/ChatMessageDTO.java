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
@ApiModel(description = "A single message on the Falcon.io application/chat")
public class ChatMessageDTO extends ResourceSupport {

	@ApiModelProperty(value = "MESSAGE ID")
	@JsonProperty("id")
	int messageId;
	
	@ApiModelProperty(value = "USER ID")
	@JsonProperty("userId")
	Integer userId;

	@ApiModelProperty(value = "MESSAGE")
	@JsonProperty("message")
	String message;
	
	@ApiModelProperty(value = "MESSAGEY'S DATE")
	@JsonProperty("date")
	Date date;
}