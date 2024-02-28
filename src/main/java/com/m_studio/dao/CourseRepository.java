package com.m_studio.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m_studio.entities.Course;
import com.m_studio.entities.User;

public interface CourseRepository extends JpaRepository<Course, Long> {
	List<Course> findCoursesByUsers(User user);

}
