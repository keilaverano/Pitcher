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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class NewPostActivity extends Activity{
	
	EditText title, description;
	ImageView camera, gallery;
	private static int RESULT_LOAD_IMAGE = 1;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_post);
		setTitle("New Idea");
		getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.blue));
		
		Typeface font = Typeface.createFromAsset(getAssets(), "quicksand.otf");	
				
        int titleId = getResources().getIdentifier("action_bar_title", "id",
	            "android");
	    TextView actionBarTitle = (TextView) findViewById(titleId);
	    actionBarTitle.setTextColor(getResources().getColor(R.color.ivory));
	    actionBarTitle.setTypeface(font);
		
		title = (EditText) findViewById(R.id.new_post_title);
		title.setTypeface(font);
		description = (EditText) findViewById(R.id.new_post_description);
		description.setTypeface(font);
		
		camera = (ImageView) findViewById(R.id.new_post_camera);
		gallery = (ImageView) findViewById(R.id.new_post_gallery);
		
		galleryAction();
		
		
	}

	public void cameraAction(){
		
	}
	
	public void galleryAction(){
		
		gallery.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i = new Intent(
						Intent.ACTION_PICK,
						android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

				startActivityForResult(i, RESULT_LOAD_IMAGE);
			}
		});
		
	}
	
	@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
         
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
 
            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
 
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
             
            //imageView = (ImageView) findViewById(R.id.register_profile_photo);
            //imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }
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
			intent = new Intent(NewPostActivity.this, TimelineActivity.class);
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
