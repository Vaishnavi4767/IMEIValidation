package com.test.imei.pojo;

public class IMEIResponse {

	private boolean status;
	
	private int validDigit;
	
	private String responseMessage;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getValidDigit() {
		return validDigit;
	}

	public void setValidDigit(int validDigit) {
		this.validDigit = validDigit;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	@Override
	public String toString() {
		return "IMEIResponse [status=" + status + ", validDigit=" + validDigit + ", responseMessage=" + responseMessage
				+ "]";
	}
	
	
}
