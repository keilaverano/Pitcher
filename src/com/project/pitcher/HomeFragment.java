package com.project.pitcher;

import java.util.ArrayList;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.Toast;

import com.project.pitcher.adapaters.PostArrayAdapter;

public class HomeFragment extends ListFragment {

	private ArrayList<Idea> ideas = new ArrayList<Idea>();
	Idea first, second, third;
	private Runnable viewParts;
	private PostArrayAdapter listAdapter;
	private ListView list;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_home, container,
				false);
		

		listAdapter = new PostArrayAdapter(getActivity(),
				R.layout.post_row_layout, ideas);
		setListAdapter(listAdapter);

		// runnable thread

		viewParts = new Runnable() {
			public void run() {
				handler.sendEmptyMessage(0);
			}
		};

		Thread thread = new Thread(null, viewParts, "MagentoBackground");
		thread.start();

		list = (ListView) rootView.findViewById(android.R.id.list);
		list.setAdapter(listAdapter);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(getActivity(),
						"You clicked at position " + position,
						Toast.LENGTH_SHORT).show();
			}
		});

		return rootView;

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
			listAdapter = new PostArrayAdapter(getActivity(),
					R.layout.post_row_layout, ideas);

			// display the list.
			setListAdapter(listAdapter);
		}
	};
}
