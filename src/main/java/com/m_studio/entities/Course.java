package com.m_studio.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "COURSES")
public class Course {
	
	@Id
	private long id;
	private String mainImage;
	private String title;
	@Column(columnDefinition = "LONGTEXT")
	private String description;
	private String subImage;
	private int price;
	private boolean enrolled;
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "user_course", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
//	private User user;
	private List<User> users = new ArrayList<>();
	private boolean addedToCart;
	private String link;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMainImage() {
		return mainImage;
	}
	public void setMainImage(String mainImage) {
		this.mainImage = mainImage;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSubImage() {
		return subImage;
	}
	public void setSubImage(String subImage) {
		this.subImage = subImage;
	}
	public boolean isAddedToCart() {
		return addedToCart;
	}
	public void setAddedToCart(boolean addedToCart) {
		this.addedToCart = addedToCart;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public boolean isEnrolled() {
		return enrolled;
	}
	public void setEnrolled(boolean enrolled) {
		this.enrolled = enrolled;
	}
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", mainImage=" + mainImage + ", title=" + title + ", description=" + description
				+ ", subImage=" + subImage + ", price=" + price + ", enrolled=" + enrolled + ", users=" + users
				+ ", addedToCart=" + addedToCart + ", link=" + link + "]";
	}
	
	
	
	
	
}
