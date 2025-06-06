package com.mfapi.app.resourse.exceptions;

import java.time.LocalDateTime;

public class StandardError {
	
	private LocalDateTime timestamp;
	private Integer status;
	private String error;
	private String path;
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	
	
	public StandardError(LocalDateTime timestamp, Integer status, String error, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.path = path;
	}


	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

	
}
