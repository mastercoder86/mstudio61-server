package com.m_studio.entities;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class Query {
	@NotBlank(message = "Name cannot be empty")
	private String name;
	@Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message="Please enter valid email address")
	private String email;
	@NotBlank(message = "Message cannot be empty")
	@Column(columnDefinition = "TEXT")
	private String message;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
