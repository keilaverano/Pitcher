package com.project.pitcher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class SettingsActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		getActionBar().setTitle("Settings");
		getActionBar().setIcon(R.drawable.ic_settings);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		
		Intent intent;
		
		switch (item.getItemId()) {

		case R.id.action_profile:
			intent = new Intent(SettingsActivity.this, ProfileActivity.class);
			startActivity(intent); 
			return true;
		case R.id.action_settings:

			return true;
		case R.id.action_seek:

			return true;
		case R.id.action_terms_and_policies:

			return true;
		case R.id.action_logout:

			return true;
		default:
			return super.onOptionsItemSelected(item);
		}

	}

}
