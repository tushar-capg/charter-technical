package com.reward.application.exception.model;

import org.springframework.stereotype.Component;
/**
 * Represents an error model to handle exception in specific manner.
 * Used to store error detail.
 */
@Component
public class ErrorModel {
	
	private String errorCode;
    private String message;
    private String timestamp;
    
    public ErrorModel(){}
    
    public ErrorModel(String errorCode, String message, String timestamp) {
    	this.errorCode = errorCode;
        this.message = message;
        this.timestamp = timestamp;
    }
    /**
	 * All the methods used to retrieves and set the details to and from fields.
	 * These getter methods are returns data from respective fields.
	 * These setter methods sets the values to the fields.
	 */
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}
