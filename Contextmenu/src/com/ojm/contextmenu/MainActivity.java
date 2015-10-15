package com.ojm.contextmenu;

import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	ListView contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contacts=(ListView) findViewById(R.id.listViewcontacts);
        String[] cont={"AA","BB","CC"};
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,cont);
        contacts.setAdapter(adapter);
        registerForContextMenu(contacts);
        }
    public void onCreateContextMenu(ContextMenu menu,View v,ContextMenuInfo info)
    {
        super.onCreateContextMenu(menu, v, info);
    	menu.setHeaderTitle("choose your options");
    	getMenuInflater().inflate(R.menu.share, menu);
    }
    public boolean onContextItemSelected(MenuItem item)
    {
    	if(item.getItemId()==R.id.call)
    	{
    		Toast.makeText(MainActivity.this, "Calling", Toast.LENGTH_SHORT).show();
    	}
    	return super.onOptionsItemSelected(item);
    }
     

   
}
