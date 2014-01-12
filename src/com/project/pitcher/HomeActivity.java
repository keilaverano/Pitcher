package com.project.pitcher;

import java.util.ArrayList;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class HomeActivity extends ListActivity {
	
	ArrayList<Idea> posts;
	Idea first, second, third;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		posts = new ArrayList<Idea>();
		populate();	
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
		
		case R.id.action_home:	
			
			return true;
		case R.id.action_profile:
			
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
	
	public void populate()
	{
		first = new Idea("Keila Verano", "@keilaverano", "App that finds anything", "This application can help the user find whatever is lost by its magical tracking features!", "11:11");
		posts.add(first);
		second = new Idea("Marjorie Bongbong", "@marjbongbong", "No regrets", "I have this idea that can build a time machine so I can go back to the past and erase my mistakes.", "03:00");
		posts.add(second);
		third = new Idea("Claire Echiverri", "@claireechiverri", "Business Lister", "I need an application that suggests every possible business I can have", "19:00");
		posts.add(third);
	}
}
