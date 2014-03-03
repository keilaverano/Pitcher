package com.project.pitcher;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.project.pitcher.adapters.FollowerArrayAdapter;
import com.project.pitcher.adapters.PostArrayAdapter;

public class IdeaListActivity extends ListActivity {

	private ArrayList<Idea> ideas = new ArrayList<Idea>();
	private PostArrayAdapter listAdapter;
	private ListView list;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_layout);

		getActionBar().setTitle("Ideas");
//		getActionBar().setIcon(R.drawable.ic_sign_up);
		getActionBar().setBackgroundDrawable(
				getResources().getDrawable(R.color.blue));
		
		addIdeas();
		
		Typeface font = Typeface.createFromAsset(getAssets(), "quicksand.otf");	
		
		int titleId = getResources().getIdentifier("action_bar_title", "id",
	            "android");
	    TextView actionBarTitle = (TextView) findViewById(titleId);
	    actionBarTitle.setTextColor(getResources().getColor(R.color.ivory));
	    actionBarTitle.setTypeface(font);
		
		listAdapter = new PostArrayAdapter(this, R.layout.post_row_layout,
				ideas, font);
		setListAdapter(listAdapter);

		list = (ListView) findViewById(android.R.id.list);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		Intent intent = new Intent(this, DetailActivity.class);

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
		
		
		ideas.add(new Idea(R.drawable.ic_girl, "Keila Verano",
				"@keilaverano", "Leaf Ice Cream",
				"Inspired from @christinebacatan's idea", "12:00",
				R.drawable.leaf_ice_cream));
		
		ideas.add(new Idea(R.drawable.ic_girl, "Keila Verano", "@keilaverano",
				"Bored", "Sleep all day long on the sand.", "03:00", R.drawable.dog));
		
		ideas.add(new Idea(
				R.drawable.ic_girl,
				"Keila Verano",
				"@keilaverano",
				"App that finds anything",
				"This application can help the user find whatever is lost by its magical tracking features!",
				"11:11", 0));
		
		ideas.add(new Idea(R.drawable.ic_girl, "Keila Verano",
				"@keilaverano", "My Lunch is Better Than Yours",
				"", "12:00",
				R.drawable.lunch_art));

	}

}
