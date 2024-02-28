package com.m_studio.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import jakarta.persistence.EntityManager;

import com.m_studio.dao.CourseRepository;
import com.m_studio.dao.MyOrderRepository;

import com.m_studio.dao.UserRepository;
import com.m_studio.entities.Course;
import com.m_studio.entities.MyOrder;
import com.m_studio.entities.User;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MyOrderRepository myOrderRepository;
	@Autowired
	private CourseRepository courseRepository;
	
	
	/* private String username,password; */

	/* private Subscriber subscriber; */

	@PostMapping("/create_order")
	public String createOrder(@RequestBody Map<String, Object> data) {
		
		System.out.println("Hey order function ex");
		System.out.println(data);
		int amount = Integer.parseInt(data.get("amount").toString());
		String username = data.get("username").toString();
		String password = data.get("password").toString();
		Order order = null;
		try {
			
			
//			List<Subscriber> subscribers = new ArrayList<>();
//			List<Object> objects = new ArrayList<>();
			
			RazorpayClient client = new RazorpayClient("rzp_test_y84XqHSv5nPYer", "aRNRG1XGthPYkdebPAGg0IWN");
			JSONObject orderRequest = new JSONObject();
			orderRequest.put("amount", amount * 100);
			orderRequest.put("currency", "INR");
			orderRequest.put("receipt", "txn_57890");
			/*
			 * orderRequest.put("username", username); orderRequest.put("password",
			 * password);
			 */
			/*
			 * JSONObject notes = new JSONObject();
			 * notes.put("notes_key_1","Tea, Earl Grey, Hot");
			 */
			/* orderRequest.put("notes",notes); */

			// creating new order
			order = client.orders.create(orderRequest);

			System.out.println(order);

			MyOrder myOrder = new MyOrder();
			User user = userRepository.findByEmailAndPassword(username, password);
//			System.out.println("s_courses:"+courseRepository.findCoursesByUsers(user));
//			subscribers.add(subscriber);
			myOrder.setAmount("Rs." + Integer.parseInt(order.get("amount").toString()) / 100);
			myOrder.setOrderId(order.get("id"));
			myOrder.setPaymentId(null);
			myOrder.setStatus("created");
			myOrder.setUser(user);
			myOrder.setReceipt(order.get("receipt"));

			myOrderRepository.save(myOrder);
			
			//return order.toString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error occured");
			//return "Error";
		}

//		return objects;
		return order.toString();
		
	}

	// update order
	@PostMapping("/update_order")
	public List<Course> updateOrder(@RequestBody Map<String, Object> data) {
		List<Object> data1;
//		List<Course> courses = new ArrayList<>();
		User user = userRepository.findByEmailAndPassword(data.get("username").toString(), data.get("password").toString());
		//data1.add(data.get("subscribedCourses"));
		 data1 = (List<Object>) data.get("subscribedCourses");
//		Course[] courses = (Course[])data.get("subscribedCourses");
		 for(Object d1:data1) {
			 Course c1 = new Course();
			 c1.setId((int)((Map<String,Object>) d1).get("id"));
			 c1.setMainImage((String)((Map<String,Object>) d1).get("mainImage"));
			 c1.setTitle((String)((Map<String,Object>) d1).get("title"));
			 c1.setDescription((String)((Map<String,Object>) d1).get("description"));
			 c1.setSubImage((String)((Map<String,Object>) d1).get("subImage"));
			 c1.setPrice((int)((Map<String,Object>) d1).get("price"));
			 List<User> users = userRepository.findUsersByCourses(courseRepository.findById(c1.getId()).get());
			 if(!users.isEmpty()) {
				 c1.getUsers().addAll(users);
			 }
			 c1.getUsers().add(user);
			 user.getCourses().add(c1);
//			 courseRepository.save(c1);
//			 courses.add(c1);
		 }
		 userRepository.save(user);
		 //userRepository.save(user);
//		 System.out.println("course :"+c1);
//		System.out.println(data1.get(1));
//		System.out.println("Here Courses :"+data1);
//		System.out.println(courses.get(1));
//		data1 = cd.addCommonData();
//		List<Course> allCourses = new ArrayList<>();
//		List<Courses> subscribedCourses = new ArrayList<>();
//		List<String> courseNames = new ArrayList<>();
//		List<Integer> prices = new ArrayList<>();
//		List<Subscriber> subscribers = new ArrayList<>();
//		allCourses.addAll((List<Course>)data1.get(0));
//		Subscriber subscriber = subscriberRepository.findByUsernameAndPassword(data.get("username").toString(),
//				data.get("password").toString());
//		subscribers.add(subscriber);
//		courseNames.addAll((List<String>) data.get("coursenames"));
//		prices.addAll((List<Integer>) data.get("prices"));
//		subscriber.getCourses().addAll(subscribedCourses);
//		for (int i = 0; i < courseNames.size(); i++) {
//			Courses c = new Courses();
//			c.setName(courseNames.get(i));
//			c.setPrice(prices.get(i));
//			for(int j=0;j<allCourses.size();j++) {
//				System.out.println("List : "+allCourses.get(j).getCourses().getName());
//				if(courseNames.get(i).equals(allCourses.get(j).getCourses().getName())) {
//					System.out.println("helllooooooooooooooo");
//					c.setImage(allCourses.get(j).getCourses().getImage());
//					System.out.println(allCourses.get(j).getCourses().getImage());
//					break;
//				}
//			}
//			c.setSubscriber(subscribers);
//			subscribedCourses.add(c);
//		}
//		subscriber.getCourses().addAll(subscribedCourses);
//		subscriberRepository.save(subscriber); //
//		System.out.println(data.get("coursenames")); // System.out.println(data);
		MyOrder myOrder = myOrderRepository.findByOrderId(data.get("razorpay_order_id").toString());
		myOrder.setPaymentId(data.get("razorpay_payment_id").toString());
		myOrder.setStatus(data.get("status1").toString());
		myOrderRepository.save(myOrder);
//		System.out.println(data);
		List<Course> subscribedCourses = courseRepository.findCoursesByUsers(user);
		return subscribedCourses;
	}
}
