package com.m_studio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m_studio.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	public Admin findByUsernameAndPassword(String username,String password);
}
