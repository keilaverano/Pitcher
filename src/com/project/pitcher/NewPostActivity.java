package com.project.pitcher;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class NewPostActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_post);
		setTitle("New Idea");
		getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.blue));
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_post, menu);
		
		
		return true;
	}
	

}
