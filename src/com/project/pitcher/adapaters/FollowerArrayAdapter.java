package com.project.pitcher.adapaters;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.pitcher.Idea;
import com.project.pitcher.Member;
import com.project.pitcher.R;

public class FollowerArrayAdapter extends ArrayAdapter<Member> {

		private final Context context;
		private final ArrayList<Member> members;

		TextView name, username;
		ImageView photo;

		public FollowerArrayAdapter(Context context, int textViewResourceId, ArrayList<Member> members) {
			super(context, textViewResourceId, members);
			this.context = context;
			this.members = members;
		}
		

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View rowView = inflater.inflate(R.layout.followers_row_layout, parent, false);
			
			name = (TextView) rowView.findViewById(R.id.follower_name);
			username = (TextView) rowView.findViewById(R.id.follower_username);
			
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
			
			//profile_photo.setImageResource(R.drawable.blah);
			
			return rowView;
		}
	}
