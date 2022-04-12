package com.project.kan.security.vo;
import com.project.kan.security.vo.JwtResponse;
public class UserResponse {
	
	private JwtRequest data;
	private String message;
	private int status;
	public JwtRequest getData() {
		return data;
	}
	public void setData(JwtRequest data) {
		this.data = data;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	

}
