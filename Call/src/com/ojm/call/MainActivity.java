package com.ojm.call;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	ListView call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        call=(ListView) findViewById(R.id.listView1);
        final Bundle b=new Bundle();
        b.putString("Abhilash","8754585222");
        b.putString("Akshar","8754589990");
        b.putString("Aswin","7565456523");
        b.putString("Arun","9686566542");
        b.putString("Banu","9456523879");
        b.putString("Bindu","8545620078");
        b.putString("Bharath","9875456523");
        b.putString("Buvaneshwary","8545896304");
        b.putString("Carel","9845652341");
        b.putString("Chandu","8754555230");
        b.putString("Chithra","8054147523");
        b.putString("Dileep","7545652390");
        b.putString("Fana","7545689731");
        b.putString("Gayathri","9874568500");

        final String[] contacts={"Abhilash","Akshar","Aswin","Arun","Banu","Bindu","Bharath","Buvaneshwary","Carel","Chandu","Chithra","Dileep","Fana","Gayathri"};
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, contacts);
        call.setAdapter(adapter);
        call.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				
				emergency(b.getString(contacts[position]));

			}
		});
    }
    /*Authour:Ramisha PV
     *Doc:7/10/2015
     *Description:Places a Call to the Selected Number
     *Arguments:Selected Number */
            
    public void emergency(String s)
    {
    	
   	 Intent intent=new Intent(Intent.ACTION_DIAL);
   	
	intent.setData(Uri.parse("tel:" + s)) ;

   	 startActivity(intent);
    }
    
}
