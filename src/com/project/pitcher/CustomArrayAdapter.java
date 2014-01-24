package com.project.pitcher;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomArrayAdapter extends ArrayAdapter<Idea> {
	private final Context context;
	private final ArrayList<Idea> ideas;

	TextView name_of_user, username, time_posted, idea_title, idea_description;
	ImageView profile_photo;

	public CustomArrayAdapter(Context context, int textViewResourceId, ArrayList<Idea> ideas) {
		super(context, textViewResourceId, ideas);
		this.context = context;
		this.ideas = ideas;
	}
	

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.row_layout, parent, false);
		
		name_of_user = (TextView) rowView.findViewById(R.id.name_of_user);
		username = (TextView) rowView.findViewById(R.id.username);
		time_posted = (TextView) rowView.findViewById(R.id.time_posted);
		idea_title = (TextView) rowView.findViewById(R.id.idea_title);
		idea_description = (TextView) rowView
				.findViewById(R.id.idea_description);
		profile_photo = (ImageView) rowView.findViewById(R.id.user_profile_photo);
		
		Idea i = ideas.get(position);

		if(name_of_user!=null)
		{
			name_of_user.setText(i.getNameOfUser());
		}
		
		if(username!=null)
		{
			username.setText(i.getUsername());
		}
		
		if(time_posted!=null)
		{
			time_posted.setText(i.getTimePosted());
		}
		
		if(idea_title!=null)
		{
			idea_title.setText(i.getIdeaTitle());
		}
		
		if(idea_description!=null)
		{
			idea_description.setText(i.getIdeaDescription());
		}
		
		return rowView;
	}
}
