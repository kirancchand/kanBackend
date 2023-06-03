package com.project.kan.security.vo;
import com.project.kan.security.vo.JwtResponse;
public class UserResponse {
	
	private Users data;
	private String message;
	private int status;
	public Users getData() {
		return data;
	}
	public void setData(Users data) {
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
