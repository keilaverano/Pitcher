package com.project.pitcher.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.pitcher.Member;
import com.project.pitcher.R;

public class FollowerArrayAdapter extends ArrayAdapter<Member> {

		private final Context context;
		private final ArrayList<Member> members;

		TextView name, username;
		ImageView photo;
		Typeface font;

		public FollowerArrayAdapter(Context context, int textViewResourceId, ArrayList<Member> members, Typeface font) {
			super(context, textViewResourceId, members);
			this.context = context;
			this.members = members;
			this.font = font;
		}
		

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			View rowView = convertView;
			
			if(rowView == null)
			{
				LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				rowView = inflater.inflate(R.layout.followers_row_layout, parent, false);
			}
			
			name = (TextView) rowView.findViewById(R.id.follower_name);
			name.setTypeface(font);
			username = (TextView) rowView.findViewById(R.id.follower_username);
			username.setTypeface(font);
			photo = (ImageView) rowView.findViewById(R.id.follower_photo);
			
			Member m = members.get(position);

			if(name!=null)
			{
				name.setText(m.getName());
			}
			if(username!=null)
			{
				username.setText(m.getUsername());
			}			
			if(photo!=null)
			{
				photo.setImageResource(m.getImage());
			}
			
			final Button button = (Button) rowView.findViewById(R.id.follow_unfollow_button);
			
			button.setTypeface(font);
			
			button.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					if(button.getText().equals("Following"))
					{
						button.setText("Follow");
						button.setBackgroundColor(button.getContext().getResources().getColor(R.color.yellow_green));
					}
					else if(button.getText().equals("Follow"))
					{
						button.setText("Following");
						button.setBackgroundColor(button.getContext().getResources().getColor(R.color.blue));
					}
				}
			});
			
			return rowView;
		}
	}
