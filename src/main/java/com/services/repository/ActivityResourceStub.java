package com.services.repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.services.model.Activity;
import com.services.model.User;



public class ActivityResourceStub {

	public List<Activity> findAllActivity(){
		return Arrays.asList(new Activity(111,"Swimming",30, new User("Varshyth","0")), new Activity(222,"Running",40,new User("Kutty","0")));
	}
	
	public Activity findActivityById(String activityId){
		return findAllActivity()
				.stream()
				.filter(activity -> activityId.equals(String.valueOf(activity
						.getId()))).collect(Collectors.toList()).get(0);
		
	}
	
	public User findActivityUserById(String activityId){
		return findAllActivity()
				.stream()
				.filter(activity -> activityId.equals(String.valueOf(activity
						.getId()))).collect(Collectors.toList()).get(0).getUser();
		
	}
		
}
