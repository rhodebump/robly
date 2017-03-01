package com.robly.common;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
{"successful":true,"message":"Member is unsubscribed."}
*/
@XmlRootElement
public class RoblyResponse {

	private boolean successful = false;
    
    public boolean isSuccessful() {
		return successful;
	}

	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	private String message = null;
    
	
	@JsonProperty("contact_id")
	private String contact_id = null;
	
	
	public String getContactId() {
		return contact_id;
	}
	
	public void setContactId(String contact_id) {
		this.contact_id = contact_id;
	}
	
    
}
