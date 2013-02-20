package com.example.cameraaaa;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;

public class CameraaaActivity extends Activity implements OnClickListener {
	//test git

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cameraaa);
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_cameraaa, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		final Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		intent.putExtra("return-data", true);
//		intent.putExtra(MediaStore.EXTRA_OUTPUT, CloretsTempFile.getOutputMediaFileUri());
		startActivityForResult(intent, 1);
		Log.e("camera","click");
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		if(resultCode==RESULT_OK&&requestCode==1){
			
			Bundle extras = data.getExtras();
		
				Bitmap photo = extras.getParcelable("data");
				ImageView imageView = new ImageView(getApplicationContext());
				imageView.setLayoutParams(new LayoutParams(photo.getWidth(), photo.getHeight()));
				imageView.setImageBitmap(photo);
				setContentView(imageView);
		
	
			
			
			Log.e("camera",""+photo.getWidth()+"."+photo.getHeight());
			
		}
	}
	

}
