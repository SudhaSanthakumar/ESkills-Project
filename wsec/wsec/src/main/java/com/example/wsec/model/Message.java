package com.example.wsec.model;

import javax.persistence.GenerationType;


import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="message")
public class Message {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="message_id")
	private int messageId;
	
	@Column(name="message")
	private String message;
	
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	


	public Message() {
		super();
	}


	public Message( String message) {
		super();
		this.message=message;
	}


	public int getMessageId() {
		return messageId;
	}


	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	

	


	
	
	
	
}
