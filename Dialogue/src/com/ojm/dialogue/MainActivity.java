package com.ojm.dialogue;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	Button alert;
	TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       alert=(Button) findViewById(R.id.button1);
       result=(TextView) findViewById(R.id.textViewresult);

        
    }
    public void alertdlg(View v)
    {
		final ArrayList list  = new ArrayList();

		final String[] colors = {"Red","Green","Blue"};
    	final AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
    	builder.setTitle("Choose your Color");
    	builder.setMultiChoiceItems(colors, null, new OnMultiChoiceClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int id, boolean arg2) {
				
			
				if(arg2==true)
				{
				list.add(id);

				}
				
				else if(list.contains(id))
				{
					list.remove(id);
				}
			}
    	});
    
				builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialogue, int id1) {
					if(list.size()!=0)
					{
						 String s="";
						for(int i=0;i<list.size();i++)
						{
					   s+= colors[(Integer) (list.get(i))] + "\n";

					  
					    result.setText(s);

					   	}


					}

				}

			});
    
				builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialogue, int arg1) {
						dialogue.dismiss();
						
					}
				});
		AlertDialog dialogue=builder.create();
    	builder.show();

    }
    
  }
