package com.ojm.widgets;

import android.os.Bundle;
import android.app.Activity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioButton;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements  android.widget.RadioGroup.OnCheckedChangeListener{

	RadioButton radiobuttonoption1;
	RadioGroup radiogroupselection;
    CheckBox selectioncheck1;
	ToggleButton togglebutton;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radiobuttonoption1=(RadioButton) findViewById(R.id.radioselection1);
        radiogroupselection=(RadioGroup) findViewById(R.id.radiogroup);
        selectioncheck1=(CheckBox) findViewById(R.id.selection1checkBox);
        togglebutton=(ToggleButton) findViewById(R.id.toggleButton);
        
        togglebutton.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean state) {
				if(state)
				{
					Toast.makeText(MainActivity.this,"Toggle button is ON",Toast.LENGTH_SHORT).show();
				}
				
				else if (!state)
				{
					Toast.makeText(MainActivity.this,"Toggle button is OFF",Toast.LENGTH_SHORT).show();

				}
				
				
			}
		});
        
        selectioncheck1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean state) {
				if(state)
				{
					Toast.makeText(MainActivity.this," Check box 1 is checked", Toast.LENGTH_SHORT).show();
				}
				
				else if (state==false)
				{
					Toast.makeText(MainActivity.this," Check box 1 is unchecked", Toast.LENGTH_SHORT).show();

				}
				
			}
		});

        radiogroupselection.setOnCheckedChangeListener(MainActivity.this);
        
        radiobuttonoption1.setOnCheckedChangeListener(new OnCheckedChangeListener() 
       {      
		  	@Override
        	public void onCheckedChanged(CompoundButton arg0, boolean state) {
        		if(state==true)
				{
					Toast.makeText(MainActivity.this, "you selected option1", Toast.LENGTH_SHORT).show();
				}
			}
		});
    }
	public void onCheckedChanged(RadioGroup arg0, int id) {
		switch (id) 
		{
		
		
		case R.id.radioselection1:
		Toast.makeText(MainActivity.this, "you selected selection1", Toast.LENGTH_SHORT).show();

		break;
		
		case R.id.radioselection2:
			Toast.makeText(MainActivity.this, "you selected selection2", Toast.LENGTH_SHORT).show();

			break;
		case R.id.radioselection3:
			Toast.makeText(MainActivity.this, "you selected selection3", Toast.LENGTH_SHORT).show();

			break;
		case R.id.radioselection4:
			Toast.makeText(MainActivity.this, "you selected selection4", Toast.LENGTH_SHORT).show();

			break;

		default:
			break;
		}
	}


	public void onClickedChanged(CompoundButton arg0, boolean state) 
	{
		if(state)
		{
			Toast.makeText(MainActivity.this, "you selected checkbox", Toast.LENGTH_SHORT).show();
		}
		else if(!state)
		{
			Toast.makeText(MainActivity.this, "unchecked", Toast.LENGTH_SHORT).show();
		}
		
	}




	



	



	

    
    
}
