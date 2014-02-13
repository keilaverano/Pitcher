package com.project.pitcher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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
	
public boolean onOptionsItemSelected(MenuItem item) {
		
		Intent intent;
		
		switch (item.getItemId()) {

		case R.id.action_accept_post:
			intent = new Intent(NewPostActivity.this, NewPostActivity.class);
			startActivity(intent); 
			return true;
		case R.id.action_cancel_post:
			this.finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}

	}
	

}
