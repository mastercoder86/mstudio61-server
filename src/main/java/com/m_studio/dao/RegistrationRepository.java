package com.m_studio.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m_studio.entities.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Integer> {
	public Registration findByEmail(String email);
}
