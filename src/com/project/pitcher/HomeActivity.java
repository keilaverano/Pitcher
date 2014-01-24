package com.project.pitcher;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class HomeActivity extends ListActivity {

	private ArrayList<Idea> ideas = new ArrayList<Idea>();;
	Idea first, second, third;
	private Runnable viewParts;
	private CustomArrayAdapter listAdapter;
	private ListView list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		listAdapter = new CustomArrayAdapter(this, R.layout.row_layout, ideas);
		setListAdapter(listAdapter);

		// runnable thread

		viewParts = new Runnable() {
			public void run() {
				handler.sendEmptyMessage(0);
			}
		};
		
		Thread thread =  new Thread(null, viewParts, "MagentoBackground");
        thread.start();
        
        list=(ListView)findViewById(android.R.id.list);
        list.setAdapter(listAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(HomeActivity.this, "You Clicked at" + position, Toast.LENGTH_SHORT).show();
            }
        });

	}

	private Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			ideas.add(new Idea(
					R.drawable.ic_user,
					"Keila Verano",
					"@keilaverano",
					"App that finds anything",
					"This application can help the user find whatever is lost by its magical tracking features!",
					"11:11"));
			ideas.add(new Idea(
					R.drawable.ic_user,
					"Marjorie Bongbong",
					"@marjbongbong",
					"No regrets",
					"I have this idea that can build a time machine so I can go back to the past and erase my mistakes.",
					"03:00"));
			ideas.add(new Idea(
					R.drawable.ic_user,
					"Claire Echiverri",
					"@claireechiverri",
					"Business Lister",
					"I need an application that suggests every possible business I can have",
					"19:00"));
			listAdapter = new CustomArrayAdapter(HomeActivity.this, R.layout.row_layout,
					ideas);

			// display the list.
			setListAdapter(listAdapter);
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {

		case R.id.action_home:
			item.setVisible(false);
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
}
