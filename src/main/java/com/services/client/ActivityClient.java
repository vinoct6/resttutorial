package com.services.client;

import java.util.List;

import javax.print.attribute.standard.Media;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.services.model.Activity;

public class ActivityClient {
	
	private Client client;
	
	public ActivityClient(){
		client = ClientBuilder.newClient(); 
	}
	
	public Activity get(String id){
		WebTarget target  = client.target("http://localhost:8080/resttutorial/v1/");
		Activity response = target.path("activities/222").request().get(Activity.class);
		System.out.println(response);
		
		String jsonResponse = target.path("activities/222").request(MediaType.APPLICATION_JSON).get(String.class);
		System.out.println(jsonResponse);
		
		return response;
	}
	
	public List<Activity> get(){
		WebTarget target  = client.target("http://localhost:8080/resttutorial/v1/");
		List<Activity> response = target.path("activities").request().get(new GenericType<List<Activity>>(){});
		return response;
	}
	
	
	public Activity create(Activity activity){
		WebTarget target  = client.target("http://localhost:8080/resttutorial/v1/");
		Response response = target.path("activities/activity").request().post(Entity.entity(activity, MediaType.APPLICATION_JSON));
		return response.readEntity(Activity.class);
	}
	
	
	
	public static void main(String[] args){
		Activity a  = new ActivityClient().get(null);
	}

}
