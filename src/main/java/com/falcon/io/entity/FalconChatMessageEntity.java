package com.falcon.io.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "message")
@Getter
@Setter
public class FalconChatMessageEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
 
	@Column(name = "userId")
	private Integer userId;
 
	@Column(name = "message")
	private String message;
	
	@Column(name = "date")
	private Date date;
 
	public FalconChatMessageEntity() {
	}

	public FalconChatMessageEntity(Integer userId, String message) {
		super();
		this.userId = userId;
		this.message = message;
		this.date = new Date();
	}
	
	public FalconChatMessageEntity(Integer userId, String message, Date date) {
		super();
		this.userId = userId;
		this.message = message;
		this.date = date;
	}

	@Override
	public String toString() {
		return "FalconChatMessageEntity [userId=" + userId + ", message=" + message + "]";
	}	
}