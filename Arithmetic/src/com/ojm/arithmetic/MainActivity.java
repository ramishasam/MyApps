package com.ojm.arithmetic;

import android.R.integer;
import android.os.Bundle;
import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	EditText entervalue,entername;
	Button result,clear;
	//TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entervalue=(EditText) findViewById(R.id.entervalueeditText);
        entername=(EditText) findViewById(R.id.nameeditText);
        result=(Button) findViewById(R.id.resultbutton);
        clear=(Button) findViewById(R.id.clearbutton);
        clear.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				entervalue.setText("");
				entername.setText("");
				
			
			}
		});
        result.setOnClickListener(new OnClickListener() {
			
			
			public void onClick(View arg0) {
				
		
				Intent intent=new Intent(MainActivity.this,SecondActivity.class);
		     	String	i1=entername.getText().toString();
		     	intent.putExtra("key1",i1);
		     	Double i2=Double.parseDouble(entervalue.getText().toString());
		     	intent.putExtra("key2", i2);
				startActivity(intent);
				
			
				
				
			}
		});
        
       
    }


    
    
}
