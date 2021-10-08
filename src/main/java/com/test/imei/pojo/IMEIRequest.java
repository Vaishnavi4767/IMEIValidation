package com.test.imei.pojo;

public class IMEIRequest {

	
	private long imeiNumber;

	public long getImeiNumber() {
		return imeiNumber;
	}

	public void setImeiNumber(long imeiNumber) {
		this.imeiNumber = imeiNumber;
	}

	@Override
	public String toString() {
		return "IMEIRequest [imeiNumber=" + imeiNumber + "]";
	}
	
	
}
