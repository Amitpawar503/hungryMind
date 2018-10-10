package com.ogs.poc.exception;

public class CoreException extends Exception{
	
	private static final long serialVersionUID = -2773444745948564922L;
	private String message;

	public CoreException(String message) {
		this.message = message;
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
