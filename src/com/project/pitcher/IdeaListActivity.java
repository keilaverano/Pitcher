package com.project.pitcher;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.project.pitcher.adapaters.FollowerArrayAdapter;
import com.project.pitcher.adapaters.PostArrayAdapter;

public class IdeaListActivity extends ListActivity {

	private ArrayList<Idea> ideas = new ArrayList<Idea>();
	private PostArrayAdapter listAdapter;
	private ListView list;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_layout);
		
		addIdeas();
		
		listAdapter = new PostArrayAdapter(this, R.layout.post_row_layout,
				ideas);
		setListAdapter(listAdapter);

		list = (ListView) findViewById(android.R.id.list);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);

	}

	public void addIdeas() {
		ideas.add(new Idea(
				R.drawable.ic_girl,
				"Keila Verano",
				"@keilaverano",
				"App that finds anything",
				"This application can help the user find whatever is lost by its magical tracking features!",
				"11:11"));
		ideas.add(new Idea(
				R.drawable.ic_girl,
				"Marjorie Bongbong",
				"@marjbongbong",
				"No regrets",
				"I have this idea that can build a time machine so I can go back to the past and erase my mistakes.",
				"03:00"));
		ideas.add(new Idea(
				R.drawable.ic_girl,
				"Claire Echiverri",
				"@claireechiverri",
				"Business Lister",
				"I need an application that suggests every possible business I can have",
				"19:00"));
	}

}
