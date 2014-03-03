package com.project.pitcher;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.project.pitcher.adapters.FollowerArrayAdapter;

public class FollowersActivity extends ListActivity {

	private ArrayList<Member> members = new ArrayList<Member>();
	private FollowerArrayAdapter listAdapter;
	private ListView list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_layout);

		getActionBar().setTitle("Followers");
		getActionBar().setIcon(R.drawable.ic_followers);
		getActionBar().setBackgroundDrawable(
				getResources().getDrawable(R.color.blue));
		
		Typeface font = Typeface.createFromAsset(getAssets(), "quicksand.otf");	

		addFollowers();

        int titleId = getResources().getIdentifier("action_bar_title", "id",
	            "android");
	    TextView actionBarTitle = (TextView) findViewById(titleId);
	    actionBarTitle.setTextColor(getResources().getColor(R.color.ivory));
	    actionBarTitle.setTypeface(font);
		
		listAdapter = new FollowerArrayAdapter(this,
				R.layout.followers_row_layout, members, font);
		setListAdapter(listAdapter);

		list = (ListView) findViewById(android.R.id.list);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.followers, menu);
		return true;
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
	}

	private void addFollowers() {
		members.add(new Member(R.drawable.ic_boy, "Louisse Herrera",
				"@louisseherrera"));
		members.add(new Member(R.drawable.ic_girl, "Marjorie Bongbong",
				"@marjbongbong"));
		members.add(new Member(R.drawable.ic_girl, "Claire Echiverri",
				"@claireechiverri"));
		members.add(new Member(R.drawable.ic_boy, "Van Fuego", "@vanfuego"));
		members.add(new Member(R.drawable.ic_girl, "Christine Bacatan",
				"@christinebacatan"));
	}
	
	public void FollowUnfollow(View v){
		
		ColorDrawable drawable = (ColorDrawable) v.getBackground();
		if(drawable.getColor()==(int)R.color.blue){
			Log.d("Debug", "unfollow");
		}
		else if(drawable.getColor()==(int)R.color.yellow_green){
			Log.d("Debug", "unfollow");
		}
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		
		Intent intent;
		
		switch (item.getItemId()) {

		case R.id.action_new_idea:
			intent = new Intent(FollowersActivity.this, NewPostActivity.class);
			startActivity(intent); 
			return true;
		case R.id.action_settings:
			intent = new Intent(FollowersActivity.this, SettingsActivity.class);
			startActivity(intent); 
			return true;
		case R.id.action_home:
			intent = new Intent(FollowersActivity.this, TimelineActivity.class);
			startActivity(intent); 
			return true;
		case R.id.action_logout:
			intent = new Intent(FollowersActivity.this, LogInActivity.class);
			startActivity(intent); 
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}

	}

}
