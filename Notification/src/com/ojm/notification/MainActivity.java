package com.ojm.notification;

import java.security.acl.NotOwnerException;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	Button notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notification=(Button) findViewById(R.id.buttonnotification);
        notification.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				/*Authour:Ramisha PV
			     *Doc:15/10/2015
			     *Description:Create a Notification*/
				
				
				NotificationCompat.Builder builder=new Builder(MainActivity.this);
				builder.setTicker("1 New Message");
				builder.setContentTitle("New Message");
				builder.setContentText("This is a New Message");
				builder.setSmallIcon(R.drawable.ic_launcher);
				//Creates an Explicit Intent
				Intent intent=new Intent(MainActivity.this,IntentActivity.class);
				
				//Creates an artificial back stack for the Activity
				TaskStackBuilder taskbuilder=TaskStackBuilder.create(MainActivity.this);
				
				//Add the back stack for the Intent
				taskbuilder.addParentStack(IntentActivity.class);
				
				//Add the Intent that starts the Activity to the top of the stack
				taskbuilder.addNextIntent(intent);
				
				//Converts the Intent into the PendingIntent
				PendingIntent penintent=taskbuilder.getPendingIntent(1,PendingIntent.FLAG_UPDATE_CURRENT);
				
				//Add the PendingIntent 
				builder.setContentIntent(penintent);
				Notification notif=builder.build();
				NotificationManager notifys=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
				notifys.notify(1, notif);
			}
		});
    }


    
    
}
