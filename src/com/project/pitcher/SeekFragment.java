package com.project.pitcher;

import java.util.ArrayList;

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

import com.project.pitcher.adapaters.PostArrayAdapter;


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
		
		listAdapter = new PostArrayAdapter(getActivity(),
				R.layout.post_row_layout, ideas);
		setListAdapter(listAdapter);		
		
		list = (ListView) rootView.findViewById(android.R.id.list);
				
		return rootView;
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);

		Idea idea = (Idea) listAdapter.getItem(position);
		Toast.makeText(getActivity(), idea.getNameOfUser() + " selected", Toast.LENGTH_LONG).show();

	}

	public void addIdeas()
	{
		ideas.add(new Idea(
				R.drawable.ic_user,
				"Keila Verano",
				"@keilaverano",
				"App that finds anything",
				"This application can help the user find whatever is lost by its magical tracking features!",
				"11:11"));
		ideas.add(new Idea(
				R.drawable.ic_user,
				"Marjorie Bongbong",
				"@marjbongbong",
				"No regrets",
				"I have this idea that can build a time machine so I can go back to the past and erase my mistakes.",
				"03:00"));
		ideas.add(new Idea(
				R.drawable.ic_user,
				"Claire Echiverri",
				"@claireechiverri",
				"Business Lister",
				"I need an application that suggests every possible business I can have",
				"19:00"));
		listAdapter = new PostArrayAdapter(getActivity(),
				R.layout.post_row_layout, ideas);
	}
	
}
