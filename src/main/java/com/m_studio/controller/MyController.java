package com.m_studio.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.m_studio.dao.CourseRepository;
import com.m_studio.dao.UserRepository;
import com.m_studio.entities.Course;
import com.m_studio.entities.Query;
import com.m_studio.entities.Registration;
import com.m_studio.entities.User;
import com.m_studio.service.CourseService;
import com.m_studio.service.EmailService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class MyController {

	@Autowired
	private CourseService courseService;
	@Autowired
	private EmailService emailService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CourseRepository courseRepository;

	@PostMapping("/courses")
	public Course saveCourse(@RequestBody Course course) {
		return courseService.save(course);
	}
	@GetMapping("/")
	public String start() {
		return "hello";
	}

	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		
		return courseService.getAllCourses();
	}

	@PostMapping("/register")
	public List<String> register(@Valid @RequestBody Registration registration, BindingResult result) {
		List<String> errors = new ArrayList<>();

		if (result.hasErrors()) {
			List<FieldError> ferrors = result.getFieldErrors();
			for (FieldError error : ferrors) {
				errors.add(error.getDefaultMessage());
			}

			errors.add("bad_cred");
		} else if (!(registration.getPassword().equals(registration.getConfirmPassword()))) {
			errors.add("password problem");
		} else {
			errors.add("no errors");
			errors.add("good_cred");
			String message = "<div style='border:5px solid red;padding:20px'>" + "<b>Name: " + registration.getName()
					+ "</b><hr/>" + "<b>Email: " + registration.getEmail() + "</b><hr/>" + "<b>Phone: "
					+ registration.getPhone() + "</b><hr/>" +

					"</div>";
			String subject = "Someone has registred";
			String to = "budhakumar21@gmail.com";
			String from = "mcoder70@gmail.com";
			boolean mailSent = emailService.sendEmail(message, subject, to, from);
			User user = new User();
			user.setName(registration.getName());
			user.setEmail(registration.getEmail());
			user.setPassword(registration.getPassword());
			userRepository.save(user);
		}
		return errors;
	}

	@PostMapping("/query")
	public List<String> sendQuery(@Valid @RequestBody Query query, BindingResult result) {
		List<String> errors = new ArrayList<>();
		if (result.hasErrors()) {
			List<FieldError> ferrors = result.getFieldErrors();
			for (FieldError error : ferrors) {
				errors.add(error.getDefaultMessage());
			}

			errors.add("bad_cred");
		} else {
			errors.add("no errors");
			errors.add("good_cred");
			String message = "<div style='border:5px solid red;padding:20px'>" + "<b>Name: " + query.getName()
					+ "</b><hr/>" + "<b>Email: " + query.getEmail() + "</b><hr/>" + "<b>Phone: " + query.getMessage()
					+ "</b><hr/>" +

					"</div>";
			String subject = "Someone has requested a callback";
			String to = "budhakumar21@gmail.com";
			String from = "mcoder70@gmail.com";
			boolean mailSent = emailService.sendEmail(message, subject, to, from);

		}
		return errors;

	}

	@PostMapping("/login")
	public Map<String,Object> processLogin(@RequestBody User user){
		Map<String,Object> loginValues = new HashMap<>();
		User user1 = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
		if(user1!=null) {
			String name = user1.getName();
			loginValues.put("name", name.substring(0,name.indexOf(" ")));
			loginValues.put("credentials", "good credentials");
			loginValues.put("username", user1.getEmail());
			loginValues.put("password",user1.getPassword());
			loginValues.put("subscribedCourses", courseRepository.findCoursesByUsers(user1));
		}
			
		
		else 
			loginValues.put("credentials", "bad credentials");
		return loginValues;
	}
}
