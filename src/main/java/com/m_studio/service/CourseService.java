package com.m_studio.service;

import java.util.List;

import com.m_studio.entities.Course;

public interface CourseService {
	public Course save(Course course);
	public List<Course> getAllCourses();
}
