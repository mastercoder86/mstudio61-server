package com.m_studio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m_studio.entities.MyOrder;

public interface MyOrderRepository extends JpaRepository<MyOrder, Integer> {
	public MyOrder findByOrderId(String orderId);
}
