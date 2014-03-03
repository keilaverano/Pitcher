package com.project.pitcher;

import java.util.ArrayList;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.project.pitcher.adapters.PostArrayAdapter;


public class SeekFragment extends ListFragment {

	private ArrayList<Idea> ideas = new ArrayList<Idea>();
	private PostArrayAdapter listAdapter;
	ListView list;

	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_seek, container,
				false);
		
		addIdeas();
		
		Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "quicksand.otf");	
		
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

		Idea a = new Idea(R.drawable.ic_girl, "Keila Verano",
				"@keilaverano", "Leaf Ice Cream",
				"Inspired from @christinebacatan's idea", "12:00",
				R.drawable.leaf_ice_cream);

		ideas.add(a);

		Idea d = new Idea(R.drawable.ic_girl, "Christine Bacatan",
				"@christinebacatan", "Flower Cream",
				"Amazing flowers placed on a cone", "12:00",
				R.drawable.boquet_ice_cream);

		ideas.add(d);
		
		Idea k = new Idea(R.drawable.ic_girl, "Keila Verano",
				"@keilaverano", "My Lunch is Better Than Yours",
				"", "12:00",
				R.drawable.lunch_art);

		ideas.add(k);

		Idea f = new Idea(R.drawable.ic_boy, "Louisse Herrera",
				"@louisseherrera", "Holi Powder",
				"Powder here, powder there, powder everywhere", "12:00",
				R.drawable.powder);

		ideas.add(f);

		Idea g = new Idea(R.drawable.ic_boy, "Van Fuego", "@vanfuego",
				"Colored Soap", "Color 'em soaps!!", "12:00", R.drawable.soap);

		ideas.add(g);

		Idea h = new Idea(R.drawable.ic_girl, "Marjorie Bongbong",
				"@marjbongbong", "Vintage floral",
				"Painting my nails all day long.", "03:00", R.drawable.nail_art);

		ideas.add(h);

		Idea i = new Idea(R.drawable.ic_boy, "Louisse Herrera",
				"@louisseherrera", "Toe Socks",
				"Toe socks on my toes! They're too cute for my life", "12:00",
				R.drawable.toe_sock);

		ideas.add(i);

	}
	
}
