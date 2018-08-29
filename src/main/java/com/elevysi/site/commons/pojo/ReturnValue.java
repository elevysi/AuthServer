package com.elevysi.site.commons.pojo;

public class ReturnValue {
	
	private int code;
	private String message;
	private String extra;
	
	public int getCode() {
		return code;
	}
	public void setCode(int success_code) {
		this.code = success_code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	
	
	

}
