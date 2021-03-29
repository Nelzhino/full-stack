package com.udemy.serverApps.models;

public class AutenticationBean {
	
	private String messages;
	
	
	public AutenticationBean() {
	
	}
	

	public AutenticationBean(String messages) {
		super();
		this.messages = messages;
	}



	public String getMessages() {
		return messages;
	}

	public void setMessages(String messages) {
		this.messages = messages;
	}
	
	
	

}
