package com.project.pitcher;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class LogInActivity extends Activity {

	EditText username_field, password_field;
	Button submit_button;
	String username = "keilaverano", password = "keila829";
	Intent intent;
	TextView sign_up;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_log_in);
		setTitle("Log In");
		
		username_field = (EditText) findViewById(R.id.username_field);
		password_field = (EditText) findViewById(R.id.password_field);
		submit_button = (Button) findViewById(R.id.submit_button);
		sign_up = (TextView) findViewById(R.id.sign_up);
		
		getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.blue));
		
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
		
		sign_up.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				proceedToRegister();
				
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
		intent = new Intent(LogInActivity.this, TimelineActivity.class);
		startActivity(intent); 
	}
	
	public void showWarning()
	{
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(LogInActivity.this);

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

	
	public void proceedToRegister()
	{
		intent = new Intent(LogInActivity.this, RegisterActivity.class);
		startActivity(intent); 
	}
}
