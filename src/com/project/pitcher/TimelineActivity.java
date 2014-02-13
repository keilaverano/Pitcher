package com.project.pitcher;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.project.pitcher.adapaters.TabsPagerAdapter;

public class TimelineActivity extends FragmentActivity implements
		ActionBar.TabListener {

	private ViewPager viewPager;
	private TabsPagerAdapter mAdapter;
	private ActionBar actionBar;
	// Tab titles
	private String[] tabs = { "Home", "Profile", "Seek" };
	private Intent intent;
	String selectedIndex = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timeline);

		// Initilization
		viewPager = (ViewPager) findViewById(R.id.pager);
		actionBar = getActionBar();
		mAdapter = new TabsPagerAdapter(getSupportFragmentManager());

		viewPager.setAdapter(mAdapter);
		actionBar.setHomeButtonEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.blue));
		getActionBar().setStackedBackgroundDrawable(getResources().getDrawable(R.drawable.tabs_changing_color));

		// Adding Tabs
		for (String tab_name : tabs) {
			actionBar.addTab(actionBar.newTab().setText(tab_name).setTabListener(this));
		}

		Intent intent = getIntent();
		selectedIndex = intent.getStringExtra("selectedIndex");
		
		
		viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				// on changing the page
				// make respected tab selected	
						
				actionBar.setSelectedNavigationItem(position);
				
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
		
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.timeline, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		
		Intent intent;
		
		switch (item.getItemId()) {

		case R.id.action_new_idea:
			intent = new Intent(TimelineActivity.this, NewPostActivity.class);
			startActivity(intent); 
			return true;
		case R.id.action_settings:
			intent = new Intent(TimelineActivity.this, SettingsActivity.class);
			startActivity(intent); 
			return true;
		case R.id.action_terms_and_policies:

			return true;
		case R.id.action_logout:
			intent = new Intent(TimelineActivity.this, LogInActivity.class);
			startActivity(intent); 
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}

	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// on tab selected
		// show respected fragment view
		viewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
	}
	
	public void goToFollowers(View v)
	{
		intent = new Intent(this, FollowersActivity.class);
		startActivity(intent); 
	}
	
	public void goToFollowing(View v)
	{
		intent = new Intent(this, FollowingActivity.class);
		startActivity(intent); 
	}
	
	public void goToIdeas(View v)
	{
		intent = new Intent(this, IdeaListActivity.class);
		startActivity(intent);
	}

}
