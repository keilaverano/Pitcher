package com.project.pitcher;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class RegisterActivity extends Activity {

	private static int RESULT_LOAD_IMAGE = 1;
	Button gallery_button, save_changes, camera_button;
	ImageView profile_photo;
	EditText name, username, password, confirm_password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		getActionBar().setTitle("Sign Up	");
		getActionBar().setIcon(R.drawable.ic_sign_up);
		getActionBar().setBackgroundDrawable(
				getResources().getDrawable(R.color.blue));

		Typeface font = Typeface.createFromAsset(getAssets(), "quicksand.otf");

		int titleId = getResources().getIdentifier("action_bar_title", "id",
				"android");
		TextView title = (TextView) findViewById(titleId);
		title.setTextColor(getResources().getColor(R.color.ivory));
		title.setTypeface(font);

		save_changes = (Button) findViewById(R.id.register_submit_button);
		name = (EditText) findViewById(R.id.register_name);
		username = (EditText) findViewById(R.id.register_username);
		password = (EditText) findViewById(R.id.register_password);
		confirm_password = (EditText) findViewById(R.id.register_confirm_password);
		camera_button = (Button) findViewById(R.id.register_camera_button);
		gallery_button = (Button) findViewById(R.id.register_gallery_button);

		setFont(font);

		gallery_button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent i = new Intent(
						Intent.ACTION_PICK,
						android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

				startActivityForResult(i, RESULT_LOAD_IMAGE);
			}
		});
		
		save_changes.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				goToLogIn();
				
			}
		});


	}

	public void setFont(Typeface font) {
		name.setTypeface(font);
		username.setTypeface(font);
		password.setTypeface(font);
		confirm_password.setTypeface(font);
		camera_button.setTypeface(font);
		gallery_button.setTypeface(font);
		save_changes.setTypeface(font);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK
				&& null != data) {
			Uri selectedImage = data.getData();
			String[] filePathColumn = { MediaStore.Images.Media.DATA };

			Cursor cursor = getContentResolver().query(selectedImage,
					filePathColumn, null, null, null);
			cursor.moveToFirst();

			int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
			String picturePath = cursor.getString(columnIndex);
			cursor.close();

			profile_photo = (ImageView) findViewById(R.id.register_profile_photo);
			profile_photo.setImageBitmap(BitmapFactory.decodeFile(picturePath));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sign_up, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {

		case R.id.action_cancel_form:
			this.finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}

	}
	
	private void goToLogIn()
	{
		Intent intent = new Intent(RegisterActivity.this, LogInActivity.class);
		startActivity(intent); 
	}

}
