package com.robly.common;
import javax.xml.bind.annotation.XmlRootElement;

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
    
    
}
