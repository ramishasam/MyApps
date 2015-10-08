package com.ojm.Conv;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;
// android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	Spinner selectvalue;
	Button coverter,clear;
	EditText fromvalue,tovalue;
	TextView result;
	
	final String[] converter={"Temperature","Currency","Distance"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selectvalue=(Spinner) findViewById(R.id.convspinner);
        coverter=(Button) findViewById(R.id.converterbutton);
        clear=(Button) findViewById(R.id.clearbutton);
        fromvalue=(EditText) findViewById(R.id.e1editText);
        tovalue=(EditText) findViewById(R.id.e2editText);
        result=(TextView) findViewById(R.id.resulttextView);
        
        clear.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				fromvalue.setText("");
				result.setText("");
				tovalue.setText("");

			}
		});
        
      
        ArrayAdapter<String> ad=new  ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_dropdown_item_1line,converter);
        selectvalue.setAdapter(ad);
        selectvalue.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				switch (position) {
				case 0:fromvalue.setHint("C");
				       tovalue.setHint("F")	;
				       coverter.setOnClickListener(new OnClickListener() {
						
						@Override
						public void onClick(View arg1) {
							tmp(arg1);
							
							
						}

						private void tmp(View arg1) {

	
	                        if(fromvalue.length()==0&&tovalue.length()==0)
								
							{
								Toast.makeText(MainActivity.this,"Please Enter any Input",Toast.LENGTH_SHORT).show();
							}
							else if(fromvalue.length()>0&&tovalue.length()>0)
							{
								Toast.makeText(MainActivity.this,"Please Enter only one Input",Toast.LENGTH_SHORT).show();

							}
							
							

							
							else if(tovalue.length()==0)
							{
								double c=Double.parseDouble(fromvalue.getText().toString());
								double f=(((c-32)*5)/9);
								result.setText(Double.toString(f));
							}
							else if(fromvalue.length()==0)
							{
								double f=Double.parseDouble(tovalue.getText().toString());
								double c=(5.0/9.0)*(f-32);
								result.setText(Double.toString(c));
							}
								
							
						}
					});
					
					break;
				case 1:fromvalue.setHint("Rs");
						tovalue.setHint("$");
						   coverter.setOnClickListener(new OnClickListener() {
							
							@Override
							public void onClick(View arg0) {
								cur(arg0);
								

							}

							private void cur(View arg1) {
								if(fromvalue.length()== 0 && tovalue.length()== 0)
								{
									Toast.makeText(MainActivity.this,"Please Enter  Input",Toast.LENGTH_SHORT).show();

								}
								else if(fromvalue.length()>0&&tovalue.length()>0)
								{
									Toast.makeText(MainActivity.this,"Please Enter only one Input",Toast.LENGTH_SHORT).show();

								}
							else if(tovalue.length()==0)
								{
									double $=Double.parseDouble(fromvalue.getText().toString());
									double rs=$/62;
									result.setText(Double.toString(rs));
								}
								else if(fromvalue.length()==0)
								{
									double rs=Double.parseDouble(tovalue.getText().toString());
									double $=rs*62;
									result.setText(Double.toString($));

							}
								 
							}
						});
								
						break;
				case 2:fromvalue.setHint("Km");
				tovalue.setHint("m");
				coverter.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						cur(arg0);

						
					}

					private void cur(View arg1) {
						 if(fromvalue.length()==0&&tovalue.length()==0)
						{
							Toast.makeText(MainActivity.this,"Please Enter  Input",Toast.LENGTH_SHORT).show();

						}
						else if(fromvalue.length()>0&&tovalue.length()>0)
						{
							Toast.makeText(MainActivity.this,"Please Enter only one Input",Toast.LENGTH_SHORT).show();

						}
						
						else if(tovalue.length()==0)
						{
							double m=Double.parseDouble(fromvalue.getText().toString());
							double km=m/1000;
							result.setText(Double.toString(km));
						}
						else if(fromvalue.length()==0)
						{
							double km=Double.parseDouble(tovalue.getText().toString());
							double m=km/1000;
							result.setText(Double.toString(m));

					}
						
					}
				} );
				
						break;							
					default:
					break;
				}
				

			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
    }
    


    

    
}
