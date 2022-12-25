package com.project.kan.common.vo;

import java.util.Map;

public class MasterResponse {
	

	private String message;
	private int status;
	private Map<String,Object> data;

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
    public Map<String, Object> getData() {
        return data;
    }
    public void setData(Map<String, Object> data) {
        this.data = data;
    }
	
	

}
