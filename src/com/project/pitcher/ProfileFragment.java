package com.project.pitcher;

import java.util.ArrayList;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.project.pitcher.adapters.PostArrayAdapter;

public class ProfileFragment extends ListFragment {

	private ArrayList<Idea> ideas = new ArrayList<Idea>();
	private PostArrayAdapter listAdapter;
	private ListView list;
	private Intent intent;
	TextView name, username, description, followers_label, following_label,
			ideas_label;
	Button followers, following, idea;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater
				.inflate(R.layout.list_layout, container, false);
		addIdeas();

		Typeface font = Typeface.createFromAsset(getActivity().getAssets(),
				"quicksand.otf");

		listAdapter = new PostArrayAdapter(getActivity(),
				R.layout.post_row_layout, ideas, font);
		setListAdapter(listAdapter);

		list = (ListView) rootView.findViewById(android.R.id.list);

		View header = inflater.inflate(R.layout.profile_header, null);
		name = (TextView) header.findViewById(R.id.profile_name_of_user);
		username = (TextView) header.findViewById(R.id.profile_username);
		username.setText("@keilaverano");
		description = (TextView) header.findViewById(R.id.profile_description);
		followers_label = (TextView) header.findViewById(R.id.followers_label);
		following_label = (TextView) header.findViewById(R.id.following_label);
		ideas_label = (TextView) header.findViewById(R.id.ideas_label);
		followers = (Button) header.findViewById(R.id.followers);
		following = (Button) header.findViewById(R.id.following);
		idea = (Button) header.findViewById(R.id.ideas);

		setFont(font);

		list.addHeaderView(header);

		idea.setText("4");
		
		followers.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				goToFollowers();

			}
		});

		following.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				goToFollowing();

			}
		});

		idea.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				goToIdeas();
			}
		});

		return rootView;
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);

		if (position != 0) {
			Intent intent = new Intent(getActivity(), DetailActivity.class);

			Idea idea = (Idea) listAdapter.getItem(position - 1);

			intent.putExtra("profile_photo", idea.getImage());
			intent.putExtra("name", idea.getNameOfUser());
			intent.putExtra("username", idea.getUsername());
			intent.putExtra("time_posted", idea.getTimePosted());
			intent.putExtra("title", idea.getIdeaTitle());
			intent.putExtra("description", idea.getIdeaDescription());
			intent.putExtra("image", idea.getIdeaImage());

			startActivity(intent);
		}
	}

	public void addIdeas() {
		ideas.add(new Idea(R.drawable.ic_girl, "Keila Verano", "@keilaverano",
				"Leaf Ice Cream", "Inspired from @christinebacatan's idea",
				"12:00", R.drawable.leaf_ice_cream));
		
		ideas.add(new Idea(R.drawable.ic_girl, "Keila Verano", "@keilaverano",
				"Bored", "Sleep all day long on the sand.", "03:00",
				R.drawable.dog));
		
		ideas.add(new Idea(R.drawable.ic_girl, "Keila Verano", "@keilaverano",
				"My Lunch is Better Than Yours", "", "12:00",
				R.drawable.lunch_art));
	}

	public void goToFollowers() {
		intent = new Intent(getActivity(), FollowersActivity.class);
		startActivity(intent);
	}

	public void goToFollowing() {
		intent = new Intent(getActivity(), FollowingActivity.class);
		startActivity(intent);
	}

	public void goToIdeas() {
		intent = new Intent(getActivity(), IdeaListActivity.class);
		startActivity(intent);
	}

	public void setFont(Typeface font) {
		name.setTypeface(font);
		username.setTypeface(font);
		description.setTypeface(font);
		following_label.setTypeface(font);
		followers_label.setTypeface(font);
		ideas_label.setTypeface(font);
		following.setTypeface(font);
		followers.setTypeface(font);
		idea.setTypeface(font);
	}

}
