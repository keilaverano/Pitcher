package com.project.pitcher;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import com.project.pitcher.adapaters.FollowerArrayAdapter;

public class FollowingActivity extends ListActivity{
	
	private ArrayList<Member> members = new ArrayList<Member>();
	private FollowerArrayAdapter listAdapter;
	private ListView list;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_layout);		

		getActionBar().setTitle("Following");
//		getActionBar().setIcon(R.drawable.ic_sign_up);
		getActionBar().setBackgroundDrawable(
				getResources().getDrawable(R.color.blue));
		
		addFollowers();
		
		listAdapter = new FollowerArrayAdapter(this, R.layout.followers_row_layout, members);
		setListAdapter(listAdapter);

		list = (ListView) findViewById(android.R.id.list);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return super.onCreateOptionsMenu(menu);
	}
	
	private void addFollowers()
	{
		members.add(new Member(R.drawable.ic_boy, "Louisse Herrera", "@louisseherrera"));
		members.add(new Member(R.drawable.ic_girl, "Marjorie Bongbong", "@marjbongbong"));
		members.add(new Member(R.drawable.ic_girl, "Claire Echiverri", "@claireechiverri"));
		members.add(new Member(R.drawable.ic_boy, "Van Fuego", "@vanfuego"));
		members.add(new Member(R.drawable.ic_girl, "Christine Bacatan", "@christinebacatan"));
	}
	

}
