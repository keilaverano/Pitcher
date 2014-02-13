package com.project.pitcher;

public class Member {

	int image;
	String name, username;
	
	public Member(int image, String name, String username) {
		this.image=image;
		this.name=name;
		this.username=username;
	}
	
	public void setImage(int image){
		this.image = image;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public int getImage(){
		return image;
	}
	
	public String getName(){
		return name;
	}
	
	public String getUsername(){
		return username;
	}

}
