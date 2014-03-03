package com.project.pitcher.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.pitcher.Idea;
import com.project.pitcher.R;

public class PostArrayAdapter extends ArrayAdapter<Idea> {
	private final Context context;
	private final ArrayList<Idea> ideas;

	TextView name_of_user, username, time_posted, idea_title, idea_description;
	ImageView profile_photo, idea_image;
	Typeface font;

	public PostArrayAdapter(Context context, int textViewResourceId, ArrayList<Idea> ideas, Typeface font) {
		super(context, textViewResourceId, ideas);
		this.context = context;
		this.ideas = ideas;
		this.font = font;
	}
	

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View rowView = convertView;
		
		if(rowView == null)
		{
			LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			rowView = inflater.inflate(R.layout.post_row_layout, parent, false);
		}
		
		name_of_user = (TextView) rowView.findViewById(R.id.home_name_of_user);
		name_of_user.setTypeface(font);
		username = (TextView) rowView.findViewById(R.id.home_username);
		username.setTypeface(font);
		time_posted = (TextView) rowView.findViewById(R.id.home_time_posted);
		time_posted.setTypeface(font);
		idea_title = (TextView) rowView.findViewById(R.id.home_idea_title);
		idea_title.setTypeface(font);
		idea_description = (TextView) rowView.findViewById(R.id.home_idea_description);
		idea_description.setTypeface(font);
		profile_photo = (ImageView) rowView.findViewById(R.id.home_profile_photo);
		idea_image = (ImageView) rowView.findViewById(R.id.home_idea_image);
		
		Idea i = ideas.get(position);

		name_of_user.setText(i.getNameOfUser());
		username.setText(i.getUsername());
		time_posted.setText("Time Posted: " +i.getTimePosted());
		idea_title.setText(i.getIdeaTitle());
		profile_photo.setImageResource(i.getImage());
		
		if(!i.getIdeaDescription().equalsIgnoreCase(""))
		{
			idea_description.setText(i.getIdeaDescription());
			idea_description.setVisibility(View.VISIBLE);
		}
		else if(i.getIdeaDescription().equals(""))
		{
			idea_description.setVisibility(View.GONE);
		}
		if(i.getIdeaImage() != 0 )
		{
			idea_image.setImageResource(i.getIdeaImage());
			idea_image.setVisibility(View.VISIBLE);
		}
		
		else if(i.getIdeaImage() == 0)
		{
			idea_image.setVisibility(View.GONE);
		}
		
		//profile_photo.setImageResource(R.drawable.blah);
		
		return rowView;
	}
}
