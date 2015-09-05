package com.services.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.services.model.Activity;
import com.services.model.User;
import com.services.repository.ActivityResourceStub;

@Path("/activities")
public class ActivityResource {

		private ActivityResourceStub stub = new ActivityResourceStub();
		
		@GET//http://localhost:8080/resttutorial/v1/activities
		@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
		public List<Activity> getActivities(){
			return stub.findAllActivity();
		}
		
		
		@GET
		@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
		@Path("{activityId}") //http://localhost:8080/resttutorial/v1/activities/222
		public Activity getActivity(@PathParam("activityId") String activityId){
			return stub.findActivityById(activityId);
		}
		
		@GET
		@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
		@Path("{activityId}/user") //http://localhost:8080/resttutorial/v1/activities/222/user
		public User getActivityUser(@PathParam("activityId") String activityId){
			return stub.findActivityUserById(activityId);
		}
		
}