package com.project.pitcher;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsActivity extends Activity {

	private static int RESULT_LOAD_IMAGE = 1;
	private static final int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 100;
    public static final int MEDIA_TYPE_IMAGE = 1;
    
    private static final String IMAGE_DIRECTORY_NAME = "Pitcher Camera";    
    private Uri fileUri;
    
	Button camera_button, gallery_button, save_changes;
	ImageView profile_photo;
	EditText name, username, password, confirm_password;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		getActionBar().setTitle("Settings");
		getActionBar().setIcon(R.drawable.ic_settings);
		getActionBar().setBackgroundDrawable(getResources().getDrawable(R.color.blue));
		
		Typeface font = Typeface.createFromAsset(getAssets(), "quicksand.otf");	
		
		int titleId = getResources().getIdentifier("action_bar_title", "id",
	            "android");
	    TextView title = (TextView) findViewById(titleId);
	    title.setTextColor(getResources().getColor(R.color.ivory));
	    title.setTypeface(font);		

		gallery_button = (Button) findViewById(R.id.settings_gallery_button);
		camera_button = (Button) findViewById(R.id.settings_camera_button);
		save_changes = (Button) findViewById(R.id.settings_submit_button);
		name = (EditText) findViewById(R.id.settings_name);
		username = (EditText) findViewById(R.id.settings_username);
		password = (EditText) findViewById(R.id.settings_password);
		confirm_password = (EditText) findViewById(R.id.settings_confirm_password);
		
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
		
		camera_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				 //captureImage();				
			}
		});
		
		if (!isDeviceSupportCamera()) {
            Toast.makeText(getApplicationContext(),
                    "Sorry! Your device doesn't support camera",
                    Toast.LENGTH_LONG).show();
            // will close the app if the device does't have camera
            finish();
        }
		
		save_changes.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				goToTimeline();
				
			}
		});

	}
	
	public void setFont(Typeface font){
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
         
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
 
            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();
 
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();
             
            profile_photo = (ImageView) findViewById(R.id.settings_profile_photo);
            profile_photo.setImageBitmap(BitmapFactory.decodeFile(picturePath));
        }
        
        if (requestCode == CAMERA_CAPTURE_IMAGE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // successfully captured the image
                // display it in image view
                previewCapturedImage();
            } else if (resultCode == RESULT_CANCELED) {
                // user cancelled Image capture
                Toast.makeText(getApplicationContext(),
                        "User cancelled image capture", Toast.LENGTH_SHORT)
                        .show();
            } else {
                // failed to capture image
                Toast.makeText(getApplicationContext(),
                        "Sorry! Failed to capture image", Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }
     
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.settings, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {

		Intent intent;

		switch (item.getItemId()) {

		case R.id.action_new_idea:
			intent = new Intent(SettingsActivity.this, NewPostActivity.class);
			startActivity(intent);
			return true;
		case R.id.action_home:
			intent = new Intent(SettingsActivity.this, TimelineActivity.class);
			startActivity(intent);
			return true;
		case R.id.action_logout:
			intent = new Intent(SettingsActivity.this, LogInActivity.class);
			startActivity(intent);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}

	}
	
	private void goToTimeline()
	{
		Intent intent = new Intent(SettingsActivity.this, TimelineActivity.class);
		startActivity(intent); 
	}
	
	private void captureImage() {
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

		fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);

		intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);

		// start the image capture Intent
		startActivityForResult(intent, CAMERA_CAPTURE_IMAGE_REQUEST_CODE);
	}
	
	
	//check if device has camera
	private boolean isDeviceSupportCamera() {
        if (getApplicationContext().getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_CAMERA)) {
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }
	
	private void previewCapturedImage() {
        try {
            // hide video preview
            //videoPreview.setVisibility(View.GONE);
 
            profile_photo.setVisibility(View.VISIBLE);
 
            // bimatp factory
            BitmapFactory.Options options = new BitmapFactory.Options();
 
            // downsizing image as it throws OutOfMemory Exception for larger
            // images
            options.inSampleSize = 8;
 
            final Bitmap bitmap = BitmapFactory.decodeFile(fileUri.getPath(),
                    options);
 
            profile_photo.setImageBitmap(bitmap);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
	
	public Uri getOutputMediaFileUri(int type) {
		return Uri.fromFile(getOutputMediaFile(type));
	}

	private static File getOutputMediaFile(int type) {

		// External sdcard location
		File mediaStorageDir = new File(
				Environment
						.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
				IMAGE_DIRECTORY_NAME);

		// Create the storage directory if it does not exist
		if (!mediaStorageDir.exists()) {
			if (!mediaStorageDir.mkdirs()) {
				Log.d(IMAGE_DIRECTORY_NAME, "Oops! Failed create "
						+ IMAGE_DIRECTORY_NAME + " directory");
				return null;
			}
		}

		// Create a media file name
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
				Locale.getDefault()).format(new Date());
		File mediaFile;
		if (type == MEDIA_TYPE_IMAGE) {
			mediaFile = new File(mediaStorageDir.getPath() + File.separator
					+ "IMG_" + timeStamp + ".jpg");
		}
		else {
			return null;
		}

		return mediaFile;
	}

}
