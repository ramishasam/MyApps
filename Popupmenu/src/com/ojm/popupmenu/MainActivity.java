package com.ojm.popupmenu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button popupbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        popupbutton=(Button) findViewById(R.id.button1);
        popupbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
		
        
      //Creating the instance of PopupMenu  
        PopupMenu pop=new PopupMenu(MainActivity.this, popupbutton);
        
        //Inflating the Popup using xml file  
        pop.getMenuInflater().inflate(R.menu.popupmenu, pop.getMenu());
        
        //registering popup with OnMenuItemClickListener  
        pop.setOnMenuItemClickListener(new OnMenuItemClickListener() {
		
		@Override
		public boolean onMenuItemClick(MenuItem arg0) {
			if(arg0.getItemId()==R.menu.popupmenu)
			{
				Toast.makeText(MainActivity.this, "You Clicked..", Toast.LENGTH_SHORT).show();
			}
		
			return false;
		}
	});
      //showing popup menu  
       pop.show();
		
			}
		});
    }
   
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
 

    
}
