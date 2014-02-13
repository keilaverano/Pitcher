package com.project.pitcher;

import java.util.ArrayList;

import com.project.pitcher.adapaters.FollowerArrayAdapter;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

public class FollowersActivity extends ListActivity {

	private ArrayList<Member> members = new ArrayList<Member>();
	private FollowerArrayAdapter listAdapter;
	private ListView list;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_layout);
		
		addFollowers();
		
		listAdapter = new FollowerArrayAdapter(this, R.layout.followers_row_layout, members);
		setListAdapter(listAdapter);

		list = (ListView) findViewById(android.R.id.list);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);

	}

	private void addFollowers()
	{
		members.add(new Member(R.drawable.ic_boy, "Louisse Herrera", "@louisseherrera"));
		members.add(new Member(R.drawable.ic_girl, "Marjorie Bongbong", "@marjbongbong"));
		members.add(new Member(R.drawable.ic_girl, "Claire Echiverri", "@claireechiverri"));
		members.add(new Member(R.drawable.ic_girl, "Van Fuego", "@vanfuego"));
		members.add(new Member(R.drawable.ic_girl, "Christine Bacatan", "@christinebacatan"));
	}

}
