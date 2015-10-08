package com.ojm.spinners;

//import android.R.String;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.TextView;
//import android.view.Menu;
import android.widget.Spinner;

public class MainActivity extends Activity implements OnItemSelectedListener{
	Spinner spinnerphone;
	TextView viewbrand;
	
    final String[] phone={"HTC","Samsung","Motog","lenovo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
        spinnerphone=(Spinner) findViewById(R.id.spinner);
        viewbrand=(TextView) findViewById(R.id.textViewbrand);
        
  
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_dropdown_item_1line,phone);
        spinnerphone.setAdapter(adapter);
        spinnerphone.setOnItemSelectedListener(new OnItemSelectedListener() {
        	@Override
        	public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
        			long arg3) 
        	{
        		viewbrand.setText(phone[position]);
        	}

        	@Override
        	public void onNothingSelected(AdapterView<?> arg0)
        	{
        		// TODO Auto-generated method stub
        		
        	}
            
            
		});
    
    
    }

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}


	


   

    
}
