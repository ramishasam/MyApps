package com.ojm.arithmetic;

import org.w3c.dom.Text;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class SecondActivity extends Activity {
	TextView message,addition,multipication,division;
	double Ad,Mul,Div;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		message=(TextView) findViewById(R.id.welcometextView);
		addition=(TextView) findViewById(R.id.addtextView);
		multipication=(TextView) findViewById(R.id.multitextView);
		division=(TextView) findViewById(R.id.divitextView);

		

		Intent intent=getIntent();
		Bundle b=intent.getExtras();
		String s1=b.getString("key1");
		message.setText("Hi "+s1);
		double s2=b.getDouble("key2");
		
		
		Ad=s2+5;
		addition.setText("Addition with 5="+Ad);
		Mul=s2*5;
		multipication.setText("Multiplication with 5="+Mul);
		Div=s2/5;
		division.setText("Division with 5="+Div);


		
	}

	

}
