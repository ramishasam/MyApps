package com.ojm.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class music extends Service {
	
	MediaPlayer mp;
	@Override
	public void onCreate() {
		super.onCreate();
		Toast.makeText(music.this,"inside service create",Toast.LENGTH_SHORT).show();
		mp = MediaPlayer.create(music.this,R.raw.sound_1);
		mp.setLooping(false);
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Toast.makeText(music.this,"inside service onstart",Toast.LENGTH_SHORT).show();
		mp.start();
		return super.onStartCommand(intent, flags, startId);
	}
	@Override
	public void onDestroy() {
		mp.stop();
		super.onDestroy();
	}
		
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
