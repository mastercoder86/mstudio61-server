package com.m_studio.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m_studio.entities.Course;
import com.m_studio.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByEmailAndPassword(String email,String password);
	public List<User> findUsersByCourses(Course course);
}
