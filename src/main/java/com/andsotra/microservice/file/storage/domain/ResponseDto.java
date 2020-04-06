package com.andsotra.microservice.file.storage.domain;

public class ResponseDto {
	
	String message;
	int statusCode;
	Object data;
	
	public ResponseDto(String message, int statusCode, Object data) {
		this.message = message;
		this.statusCode = statusCode;
		this.data = data;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	

}
