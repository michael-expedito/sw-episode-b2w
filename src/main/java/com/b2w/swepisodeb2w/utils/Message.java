package com.b2w.swepisodeb2w.utils;

public class Message {

	private String message;
	
	private TypeMessage type;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public TypeMessage getType() {
		return type;
	}

	public void setType(TypeMessage type) {
		this.type = type;
	}

	public Message(String message, TypeMessage type) {
		this.message = message;
		this.type = type;
	}
	
}
