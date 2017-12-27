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
@ApiModel(description = "A single message on the Falcon.io application")
public class FalconMessageDTO extends ResourceSupport {

	@ApiModelProperty(value = "MESSAGE ID")
	@JsonProperty("messageId")
	Integer messageId;

	@ApiModelProperty(value = "OWNER")
	@JsonProperty("owner")
	String owner;

	@ApiModelProperty(value = "MESSAGE DESCRIPTION")
	@JsonProperty("messageDescription")
	String messageDescription;

	@ApiModelProperty(value = "DATE")
	@JsonProperty("date")
	Date date;
}
