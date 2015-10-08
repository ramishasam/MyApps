package com.ojm.hardwares;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.MediaStore.Images;
import android.provider.MediaStore.Images.Media;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button call,browser,camera,gallary;
	ImageView image;
	private static final int CAMERA = 1313;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        call=(Button) findViewById(R.id.phonebutton);
        browser=(Button) findViewById(R.id.browserbutton);
        camera=(Button) findViewById(R.id.camerabutton);
        image=(ImageView) findViewById(R.id.imageView);
        gallary=(Button) findViewById(R.id.gallerybutton);
        
       
        camera.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) 
			{
		 	Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			startActivityForResult(intent, CAMERA);
			/*ContentValues values=new ContentValues();
			values.put(Images.Media.DATE_TAKEN, System.currentTimeMillis());
			values.put(Images.Media.MIME_TYPE, "images/jepeg");
		final	String filepath = null;
			values.put(MediaStore.MediaColumns.DATA, filepath);
			final Context context = null;
			context.getContentResolver().insert(Images.Media.EXTERNAL_CONTENT_URI, values);
			*/
			
		}
		});
    }
        protected void onActivityResult(int requestCode, int resultCode, 
    			Intent data) {
    	
    		super.onActivityResult(requestCode, resultCode, data);
    		
    		if(requestCode == CAMERA)
    		{
    			if(resultCode==RESULT_OK)
    			{
    				Bitmap bm = (Bitmap) data.getExtras().get("data");
    				image.setImageBitmap(bm);
    				//MediaStore.Images.Media.insertImage(getContentResolver(), bm, "Camera", "Flower");

    			}
    		
    			else if(resultCode==RESULT_CANCELED)
    			{
    				Toast.makeText(MainActivity.this,"ERROR WITH CAMERA",Toast.LENGTH_SHORT).show();
    			}

    		}
    		gallary.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					Intent intent=new Intent(Intent.ACTION_VIEW);
					
					intent.setData(Uri.parse("image"));
					startActivity(intent);
				}
			});
        
        browser.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
          Intent intent=new Intent(Intent.ACTION_VIEW);
          intent.setData(Uri.parse("http://www.google.com"));
          startActivity(intent);
				
			}
		});
        call.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(Intent.ACTION_CALL);
				intent.setData(Uri.parse("tel:9686566576")) ;
				startActivity(intent);
				
				
			}
		});
    }


    
}
