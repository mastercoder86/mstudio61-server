package com.m_studio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m_studio.dao.CourseRepository;
import com.m_studio.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	CourseRepository courseRepository;

	@Override
	public Course save(Course course) {
		
		return courseRepository.save(course);
	}

	@Override
	public List<Course> getAllCourses() {
		
		return courseRepository.findAll();
	}

}
