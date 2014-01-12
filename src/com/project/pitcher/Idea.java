package com.project.pitcher;


public class Idea {
	
	String name_of_user, username, idea_title, idea_description, time_posted;
	
	public Idea() {

		
	}
	
	public Idea(String name_of_user, String username, String idea_title, String idea_description, String time_posted)
	{
		this.name_of_user = name_of_user;
		this.username = username;
		this.idea_title = idea_title;
		this.idea_description = idea_description;
		this.time_posted = time_posted;
	}

}
