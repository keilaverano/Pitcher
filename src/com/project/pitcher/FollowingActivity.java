package com.project.pitcher;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.project.pitcher.adapters.FollowerArrayAdapter;

public class FollowingActivity extends ListActivity{
	
	private ArrayList<Member> members = new ArrayList<Member>();
	private FollowerArrayAdapter listAdapter;
	private ListView list;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_layout);		

		getActionBar().setTitle("Following");
		getActionBar().setIcon(R.drawable.ic_followers);
		getActionBar().setBackgroundDrawable(
				getResources().getDrawable(R.color.blue));
		
		addFollowers();
		
		Typeface font = Typeface.createFromAsset(getAssets(), "quicksand.otf");	
		
        int titleId = getResources().getIdentifier("action_bar_title", "id",
	            "android");
	    TextView actionBarTitle = (TextView) findViewById(titleId);
	    actionBarTitle.setTextColor(getResources().getColor(R.color.ivory));
	    actionBarTitle.setTypeface(font);
		
		listAdapter = new FollowerArrayAdapter(this, R.layout.followers_row_layout, members, font);
		setListAdapter(listAdapter);

		list = (ListView) findViewById(android.R.id.list);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.followers, menu);
		return true;
	}
	
	private void addFollowers()
	{
		members.add(new Member(R.drawable.ic_boy, "Louisse Herrera", "@louisseherrera"));
		members.add(new Member(R.drawable.ic_girl, "Marjorie Bongbong", "@marjbongbong"));
		members.add(new Member(R.drawable.ic_girl, "Claire Echiverri", "@claireechiverri"));
		members.add(new Member(R.drawable.ic_boy, "Van Fuego", "@vanfuego"));
		members.add(new Member(R.drawable.ic_girl, "Christine Bacatan", "@christinebacatan"));
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		
		Intent intent;
		
		switch (item.getItemId()) {

		case R.id.action_new_idea:
			intent = new Intent(FollowingActivity.this, NewPostActivity.class);
			startActivity(intent); 
			return true;
		case R.id.action_settings:
			intent = new Intent(FollowingActivity.this, SettingsActivity.class);
			startActivity(intent); 
			return true;
		case R.id.action_home:
			intent = new Intent(FollowingActivity.this, TimelineActivity.class);
			startActivity(intent); 
			return true;
		case R.id.action_logout:
			intent = new Intent(FollowingActivity.this, LogInActivity.class);
			startActivity(intent); 
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}

	}
	

}
