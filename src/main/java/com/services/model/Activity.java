package com.services.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Activity {

	private String description;
	private int duration;
	private int id;
	
	private User user;

	public Activity() {

	}

	public Activity(int id, String description, int duration,User user) {
		this.description = description;
		this.duration = duration;
		this.id = id;
		this.user = user;

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activity other = (Activity) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Activity [description=" + description + ", duration="
				+ duration + ", id=" + id + ", user=" + user + "]";
	}
	
	

}
