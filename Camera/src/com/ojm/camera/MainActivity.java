package com.ojm.camera;

import android.os.Bundle;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
//import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button camera;
	TextView dis;
	ImageView image;
	private static final int CAMERA=1313;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        camera=(Button) findViewById(R.id.buttoncamera);
        dis=(TextView) findViewById(R.id.cameratextView);
        image=(ImageView) findViewById(R.id.imageView);
        camera.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				
				startActivityForResult(intent,CAMERA);
				
				
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

   
}
}
