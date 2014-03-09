package com.project.pitcher;

import java.util.ArrayList;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.project.pitcher.adapters.PostArrayAdapter;

public class HomeFragment extends ListFragment {

	private ArrayList<Idea> ideas = new ArrayList<Idea>();
	private PostArrayAdapter listAdapter;
	ListView list;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_home, container,
				false);

		addIdeas();

		Typeface font = Typeface.createFromAsset(getActivity().getAssets(),
				"quicksand.otf");

		listAdapter = new PostArrayAdapter(getActivity(),
				R.layout.post_row_layout, ideas, font);
		setListAdapter(listAdapter);

		list = (ListView) rootView.findViewById(android.R.id.list);

		return rootView;

	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);

		Intent intent = new Intent(getActivity(), DetailActivity.class);

		Idea idea = (Idea) listAdapter.getItem(position);

		intent.putExtra("profile_photo", idea.getImage());
		intent.putExtra("name", idea.getNameOfUser());
		intent.putExtra("username", idea.getUsername());
		intent.putExtra("time_posted", idea.getTimePosted());
		intent.putExtra("title", idea.getIdeaTitle());
		intent.putExtra("description", idea.getIdeaDescription());
		intent.putExtra("image", idea.getIdeaImage());

		startActivity(intent);
	}

	public void addIdeas() {

		ideas.add(new Idea(R.drawable.ic_girl, "Marjorie Bongbong",
				"@marjbongbong", "Kiss my Pa-Pa-Panda Panda Panda Lips", "", "12:00",
				R.drawable.panda_lips));

		ideas.add(new Idea(R.drawable.ic_girl, "Keila Verano", "@keilaverano",
				"Leaf Ice Cream", "Inspired from @christinebacatan's idea",
				"12:00", R.drawable.leaf_ice_cream));

		ideas.add(new Idea(
				R.drawable.ic_girl,
				"Marjorie Bongbong",
				"@marjbongbong",
				"No regrets",
				"I have this idea that can build a time machine so I can go back to the past and erase my mistakes.",
				"03:00", 0));

		ideas.add(new Idea(R.drawable.ic_girl, "Christine Bacatan",
				"@christinebacatan", "Flower Cream",
				"Amazing flowers placed on a cone", "12:00",
				R.drawable.boquet_ice_cream));

		ideas.add(new Idea(
				R.drawable.ic_girl,
				"Claire Echiverri",
				"@claireechiverri",
				"Business Lister",
				"I need an application that suggests every possible business I can have",
				"19:00", 0));

		ideas.add(new Idea(R.drawable.ic_boy, "Louisse Herrera",
				"@louisseherrera", "Holi Powder",
				"Powder here, powder there, powder everywhere", "12:00",
				R.drawable.powder));

		ideas.add(new Idea(
				R.drawable.ic_girl,
				"Keila Verano",
				"@keilaverano",
				"App that finds anything",
				"This application can help the user find whatever is lost by its magical tracking features!",
				"11:11", 0));

		ideas.add(new Idea(R.drawable.ic_boy, "Van Fuego", "@vanfuego",
				"Colored Soap", "", "12:00", R.drawable.soap));

		ideas.add(new Idea(R.drawable.ic_girl, "Marjorie Bongbong",
				"@marjbongbong", "Vintage floral",
				"Painting my nails all day long.", "03:00", R.drawable.nail_art));

		ideas.add(new Idea(R.drawable.ic_girl, "Claire Echiverri",
				"@claireechiverri", "Purple Sofa",
				"I was so lonely that I decided to paint our sofa purple",
				"12:00", R.drawable.purple_sofa));

		ideas.add(new Idea(R.drawable.ic_girl, "Keila Verano", "@keilaverano",
				"My Lunch is Better Than Yours", "", "12:00",
				R.drawable.lunch_art));
	}
}
