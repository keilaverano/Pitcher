package com.project.pitcher;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends Activity {
	
	private static final String TAG_IMAGE = "profile_photo";
	private static final String TAG_NAME = "name";
	private static final String TAG_USERNAME = "username";
	private static final String TAG_TIME_POSTED = "time_posted";
	private static final String TAG_IDEA_TITLE = "title";
	private static final String TAG_IDEA_DESCRIPTION = "description";
	private static final String TAG_IDEA_IMAGE = "image";
	private String name, username, title, description, time_posted;	
	private int image, profile_photo;
	
	ImageView detail_image, detail_profile_photo;
	TextView detail_name, detail_username, detail_title, detail_description;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.blue));
		
		Typeface font = Typeface.createFromAsset(getAssets(), "quicksand.otf");	
		
		Intent intent = getIntent();		

		profile_photo = intent.getIntExtra(TAG_IMAGE, R.drawable.ic_user);
        name = intent.getStringExtra(TAG_NAME);
        username = intent.getStringExtra(TAG_USERNAME);
        time_posted = intent.getStringExtra(TAG_TIME_POSTED);
        title = intent.getStringExtra(TAG_IDEA_TITLE);
        description = intent.getStringExtra(TAG_IDEA_DESCRIPTION);
        image = intent.getIntExtra(TAG_IDEA_IMAGE, 0);
        
        getActionBar().setTitle(username);
        int titleId = getResources().getIdentifier("action_bar_title", "id", "android");
	    TextView actionBarTitle = (TextView) findViewById(titleId);
	    actionBarTitle.setTextColor(getResources().getColor(R.color.ivory));
	    actionBarTitle.setTypeface(font);
        
        detail_profile_photo = (ImageView) findViewById(R.id.detail_profile_photo);
        detail_profile_photo.setImageResource(profile_photo);
        
        detail_name = (TextView) findViewById(R.id.detail_name);
        detail_name.setText(name);
        detail_name.setTypeface(font);
        
        detail_username = (TextView) findViewById(R.id.detail_username);
        detail_username.setText(username);
        detail_username.setTypeface(font);
        
        detail_title = (TextView) findViewById(R.id.detail_title);
        detail_title.setText(title);
        detail_title.setTypeface(font);
        
        detail_description = (TextView) findViewById(R.id.detail_description);
        
        detail_image = (ImageView) findViewById(R.id.detail_image);
        
        if(!description.equalsIgnoreCase(""))
		{
        	detail_description.setText(description);        
            detail_description.setTypeface(font);
			detail_description.setVisibility(View.VISIBLE);
		}
        else if(description.equals(""))
        {
        	detail_description.setVisibility(View.GONE);
        }
        
        if(image != 0){
        	
        	detail_image.setImageResource(image);
        	detail_image.setVisibility(View.VISIBLE);
        	
        }
        else if(image == 0)
        {
        	detail_image.setVisibility(View.GONE);
        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detail, menu);
		
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {

		Intent intent;

		switch (item.getItemId()) {

		case R.id.action_home:
			intent = new Intent(DetailActivity.this, TimelineActivity.class);
			startActivity(intent);
			return true;
		case R.id.action_new_idea:
			intent = new Intent(DetailActivity.this, TimelineActivity.class);
			startActivity(intent);
			return true;
		case R.id.action_logout:
			intent = new Intent(DetailActivity.this, LogInActivity.class);
			startActivity(intent);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
