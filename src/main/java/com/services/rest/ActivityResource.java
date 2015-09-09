package com.services.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.services.model.Activity;
import com.services.model.User;
import com.services.repository.ActivityResourceStub;

@Path("/activities")
public class ActivityResource {

		private ActivityResourceStub stub = new ActivityResourceStub();
		
		
		
		@GET
		@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
		@Path("{activityId}") //http://localhost:8080/resttutorial/v1/activities/222
		public Response getActivityDetail(@PathParam("activityId") String activityId){
			if(activityId == null){
				return Response.status(Status.BAD_REQUEST).build();
			}
			
			Activity activity  = stub.findActivityById(activityId);
			if (activity == null){
				return Response.status(Status.NOT_FOUND).build();
			}
			
			return Response.ok().entity(activity).build();
		}
		
		@POST
		@Path("activity")
		@Consumes(MediaType.APPLICATION_XML)
		@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
		public Activity createNewActivity(Activity activity){
			System.out.println(activity);
			return activity;
		}
		
		
		@POST
		@Path("activity")
		@Consumes(MediaType.APPLICATION_XML)
		@Produces(MediaType.TEXT_PLAIN)
		public void createNewActivity(MultivaluedHashMap<String, String> params){
			System.out.println(params);
		}
		
		
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
