package com.project.pitcher;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;


public class MainActivity extends Activity {

	EditText username_field, password_field;
	ImageView submit_button;
	String username = "keilaverano", password = "keila829";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		username_field = (EditText) findViewById(R.id.username_field);
		password_field = (EditText) findViewById(R.id.password_field);
		submit_button = (ImageView) findViewById(R.id.submit_button);
		
		submit_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(username_field.getText().toString().equals(username) && password_field.getText().toString().equals(password))
				{
					proceedToHome();
				}
				else
				{
					showWarning();
				}		
			}
		});	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return false;
	}
	
	public void proceedToHome()
	{
		Intent intent = new Intent(MainActivity.this, HomeActivity.class);
		startActivity(intent); 
	}
	
	public void showWarning()
	{
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

		alertDialogBuilder.setTitle("Warning!");

		alertDialogBuilder
				.setMessage("Incorrect username or password.")
				.setCancelable(false)
				.setNeutralButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {

					}
				});

		AlertDialog alertDialog = alertDialogBuilder.create();

		alertDialog.show();
	}

}
