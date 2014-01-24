package com.project.pitcher;


public class Idea {
	
	private int image;
	private String name_of_user, username, idea_title, idea_description, time_posted;
	
	public Idea() {

		
	}
	
	public Idea(int image, String name_of_user, String username, String idea_title, String idea_description, String time_posted)
	{
		this.image = image;
		this.name_of_user = name_of_user;
		this.username = username;
		this.idea_title = idea_title;
		this.idea_description = idea_description;
		this.time_posted = time_posted;
	}

	public void setImage(int image)
	{
		this.image=image;
	}
	
	public int getImage()
	{
		return image;
	}
	
	public void setNameOfUser(String name_of_user)
	{
		this.name_of_user=name_of_user;
	}
	
	public String getNameOfUser()
	{
		return name_of_user;
	}
	
	public void setUsernmae(String username)
	{
		this.username=username;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public void setIdeaTitle(String idea_title)
	{
		this.idea_title=idea_title;
	}
	
	public String getIdeaTitle()
	{
		return idea_title;
	}
	
	public void setIdeaDescription(String idea_description)
	{
		this.idea_description=idea_description;
	}
	
	public String getIdeaDescription()
	{
		return idea_description;
	}
	
	public void setTimePosted(String time_posted)
	{
		this.time_posted=time_posted;
	}
	
	public String getTimePosted()
	{
		return time_posted;
	}

}
