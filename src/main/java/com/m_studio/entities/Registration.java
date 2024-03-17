package com.m_studio.entities;

import javax.validation.constraints.Pattern;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Registration {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotBlank(message = "Name cannot be empty")
	private String name;
	@Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message="Please enter valid email address")
	private String email;
	@NotBlank(message = "Password cannot be empty")
	private String password;
	@Transient
	private String confirmPassword;
	@Size(min = 10,message = "Please enter valid mobile number")
	private String phone;
	@Pattern(regexp = "(10-15|15-20|20-25|25-30|30-35|$)",message="Please select age")
	private String age;
	@NotBlank(message = "Address cannot be empty")
	@Column(columnDefinition = "TEXT")
	private String address;
	@NotBlank(message = "City cannot be empty")
	private String city;
	@NotBlank(message = "State cannot be empty")
	private String state;
	@Size(min = 6,message = "Please enter valid pin code")
	private String pinCode;
	private boolean subscribed;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	public boolean isSubscribed() {
		return subscribed;
	}
	public void setSubscribed(boolean subscribed) {
		this.subscribed = subscribed;
	}
	
	

}
